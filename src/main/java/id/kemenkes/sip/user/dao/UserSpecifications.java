package id.kemenkes.sip.user.dao;

import id.kemenkes.sip.group.entity.Group;
import id.kemenkes.sip.user.entity.User;
import id.kemenkes.sip.user.entity.User_;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecifications {
	
	public static Specification<User> byLikeUsernameFirstnameLastnameGroupId(final String username, final String firstName, final String lastName, final String groupId){
		return new Specification<User>(){

			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				Predicate p = cb.conjunction();
				
				p = cb.and(p, cb.like(root.get(User_.username), username));
				p = cb.and(p, cb.like(root.get(User_.firstname), firstName));
				p = cb.and(p, cb.like(root.get(User_.lastname), lastName));
				
				if(!StringUtils.isEmpty(groupId)){
					Join<User, Group> joinGroup = root.join(User_.group);
					p = cb.and(p, cb.equal(joinGroup.get("id"), groupId));
				}
				
				return p;
			}
			
		};
	}

}
