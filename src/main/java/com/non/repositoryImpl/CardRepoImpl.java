//import com.non.model.Card;
//import com.non.repository.AbstractCardRepo;
//import com.non.repository.*;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.TypedQuery;
//import jakarta.persistence.criteria.CriteriaBuilder;
//import jakarta.persistence.criteria.CriteriaQuery;
//import jakarta.persistence.criteria.Root;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
//
//@Repository
//public class CardRepoImpl implements AbstractCardRepo {
//
//    private final EntityManager entityManager;
//
//    public CardRepoImpl(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//    @Override
//    public Card findCardByUserIdAndQuesId(Long userId, Integer quesId) {
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Card> cq = cb.createQuery(Card.class);
//        Root<Card> root = cq.from(Card.class);
//
//        cq.select(root);
//        cq.where(cb.and(
//                cb.equal(root.get("userId"), userId),
//                cb.equal(root.get("quesId"), quesId)
//        ));
//        cq.orderBy(cb.desc(root.get("id")));
//
//        TypedQuery<Card> tq = entityManager.createQuery(cq);
//        return tq.getSingleResult();
//    }
//}