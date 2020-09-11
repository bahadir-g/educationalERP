package com.example.okul.specs;

import com.example.okul.entity.DersProgrami;
import com.example.okul.model.DersProgramiModel;
import com.example.okul.model.SinifVeGunModel;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class DersProgramiSpecs {

        public  Specification<DersProgrami> getOgretmenBySinifAndGun(SinifVeGunModel filterParams){

            return (root, criteriaQuery, criteriaBuilder) -> {
                List<Predicate> predicates = new ArrayList<>();

               if (filterParams.getSinifRef() != null){
                    predicates.add(criteriaBuilder.equal(root.join("sinifRef").get("sinifAdi"),filterParams.getSinifRef()));
                }
                if (filterParams.getGun() != null){
                    predicates.add(criteriaBuilder.equal(root.get("gun"),filterParams.getGun()));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

            };

        }
}
