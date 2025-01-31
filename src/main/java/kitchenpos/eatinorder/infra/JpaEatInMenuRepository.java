package kitchenpos.eatinorder.infra;

import kitchenpos.eatinorder.domain.EatInMenu;
import kitchenpos.eatinorder.domain.EatInMenuRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface JpaEatInMenuRepository extends EatInMenuRepository, JpaRepository<EatInMenu, UUID> {
}
