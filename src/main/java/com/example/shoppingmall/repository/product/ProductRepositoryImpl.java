package com.example.shoppingmall.repository.product;

import com.example.shoppingmall.data.dto.queryselect.SelectIDQuery;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.example.shoppingmall.data.entity.QProduct.product;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public BooleanExpression eqUsername(String username) {
        if (!StringUtils.hasText(username)){
            return null;
        }
        return product.user.username.eq(username);
    }

    @Override
    public List<SelectIDQuery> selectIDFromUsername(String username){
        BooleanExpression status = null;
        status = eqUsername(username);

        // BooleanExpression 이 모두 null 이라면 모든 쿼리를 불러오므로 조건처리
        if (status == null) {
            return null;
        }

        return queryFactory.select(Projections.fields(
                SelectIDQuery.class, product.id))
                .from(product)
                .where(status)
                .fetch();
    }

    @Override
    public BooleanExpression eqProductIDList(List<Long> IDList){
        if (IDList == null) {
            return null;
        }
        return product.id.in(IDList);
    }

    @Override
    public void deleteProductID(List<Long> IDList){
        BooleanExpression status = null;
        status = eqProductIDList(IDList);

        if (status == null) {
            return;
        }

        queryFactory.delete(product)
                .where(status)
                .execute();
    }
}
