package kitchenpos.takeoutorder.infra;

import kitchenpos.takeoutorder.domain.TakeOutMenu;
import kitchenpos.takeoutorder.domain.TakeOutMenuRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface JpaTakeOutMenuRepository extends TakeOutMenuRepository, JpaRepository<TakeOutMenu, UUID> {

}
