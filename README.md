# 키친포스

## 퀵 스타트

```sh
cd docker
docker compose -p kitchenpos up -d
```

## 요구 사항

### 상품

- 상품을 등록할 수 있다.
- 상품의 가격이 올바르지 않으면 등록할 수 없다.
    - 상품의 가격은 0원 이상이어야 한다.
- 상품의 이름이 올바르지 않으면 등록할 수 없다.
    - 상품의 이름에는 비속어가 포함될 수 없다.
- 상품의 가격을 변경할 수 있다.
- 상품의 가격이 올바르지 않으면 변경할 수 없다.
    - 상품의 가격은 0원 이상이어야 한다.
- 상품의 가격이 변경될 때 메뉴의 가격이 메뉴에 속한 상품 금액의 합보다 크면 메뉴가 숨겨진다.
- 상품의 목록을 조회할 수 있다.

### 메뉴 그룹

- 메뉴 그룹을 등록할 수 있다.
- 메뉴 그룹의 이름이 올바르지 않으면 등록할 수 없다.
    - 메뉴 그룹의 이름은 비워 둘 수 없다.
- 메뉴 그룹의 목록을 조회할 수 있다.

### 메뉴

- 1 개 이상의 등록된 상품으로 메뉴를 등록할 수 있다.
- 상품이 없으면 등록할 수 없다.
- 메뉴에 속한 상품의 수량은 0 이상이어야 한다.
- 메뉴의 가격이 올바르지 않으면 등록할 수 없다.
    - 메뉴의 가격은 0원 이상이어야 한다.
- 메뉴에 속한 상품 금액의 합은 메뉴의 가격보다 크거나 같아야 한다.
- 메뉴는 특정 메뉴 그룹에 속해야 한다.
- 메뉴의 이름이 올바르지 않으면 등록할 수 없다.
    - 메뉴의 이름에는 비속어가 포함될 수 없다.
- 메뉴의 가격을 변경할 수 있다.
- 메뉴의 가격이 올바르지 않으면 변경할 수 없다.
    - 메뉴의 가격은 0원 이상이어야 한다.
- 메뉴에 속한 상품 금액의 합은 메뉴의 가격보다 크거나 같아야 한다.
- 메뉴를 노출할 수 있다.
- 메뉴의 가격이 메뉴에 속한 상품 금액의 합보다 높을 경우 메뉴를 노출할 수 없다.
- 메뉴를 숨길 수 있다.
- 메뉴의 목록을 조회할 수 있다.

### 주문 테이블

- 주문 테이블을 등록할 수 있다.
- 주문 테이블의 이름이 올바르지 않으면 등록할 수 없다.
    - 주문 테이블의 이름은 비워 둘 수 없다.
- 빈 테이블을 해지할 수 있다.
- 빈 테이블로 설정할 수 있다.
- 완료되지 않은 주문이 있는 주문 테이블은 빈 테이블로 설정할 수 없다.
- 방문한 손님 수를 변경할 수 있다.
- 방문한 손님 수가 올바르지 않으면 변경할 수 없다.
    - 방문한 손님 수는 0 이상이어야 한다.
- 빈 테이블은 방문한 손님 수를 변경할 수 없다.
- 주문 테이블의 목록을 조회할 수 있다.

### 주문

- 1개 이상의 등록된 메뉴로 배달 주문을 등록할 수 있다.
- 1개 이상의 등록된 메뉴로 포장 주문을 등록할 수 있다.
- 1개 이상의 등록된 메뉴로 매장 주문을 등록할 수 있다.
- 주문 유형이 올바르지 않으면 등록할 수 없다.
- 메뉴가 없으면 등록할 수 없다.
- 매장 주문은 주문 항목의 수량이 0 미만일 수 있다.
- 매장 주문을 제외한 주문의 경우 주문 항목의 수량은 0 이상이어야 한다.
- 배달 주소가 올바르지 않으면 배달 주문을 등록할 수 없다.
    - 배달 주소는 비워 둘 수 없다.
- 빈 테이블에는 매장 주문을 등록할 수 없다.
- 숨겨진 메뉴는 주문할 수 없다.
- 주문한 메뉴의 가격은 실제 메뉴 가격과 일치해야 한다.
- 주문을 접수한다.
- 접수 대기 중인 주문만 접수할 수 있다.
- 배달 주문을 접수되면 배달 대행사를 호출한다.
- 주문을 서빙한다.
- 접수된 주문만 서빙할 수 있다.
- 주문을 배달한다.
- 배달 주문만 배달할 수 있다.
- 서빙된 주문만 배달할 수 있다.
- 주문을 배달 완료한다.
- 배달 중인 주문만 배달 완료할 수 있다.
- 주문을 완료한다.
- 배달 주문의 경우 배달 완료된 주문만 완료할 수 있다.
- 포장 및 매장 주문의 경우 서빙된 주문만 완료할 수 있다.
- 주문 테이블의 모든 매장 주문이 완료되면 빈 테이블로 설정한다.
- 완료되지 않은 매장 주문이 있는 주문 테이블은 빈 테이블로 설정하지 않는다.
- 주문 목록을 조회할 수 있다.

## 용어 사전


### 메뉴

| 한글명    | 영문명          | 설명                             |
|--------|--------------|--------------------------------|
| 메뉴     | Menu         | 메뉴그룹에 속하는 주문 가능 단위             |
| 메뉴그룹   | MenuGroup    | 메뉴를 분류한 그룹                     |
| 메뉴상품   | MenuProduct  | 메뉴가 포함하고 있는 상품                 |
| 메뉴상품목록 | MenuProducts | 메뉴가 포함하고 있는 상품 목록              |
| 가격     | Price        | 메뉴 금액                          |
| 노출여부   | Displayed    | 사용자에게 메뉴를 보이게 하거나 숨기게 하는 구분 단위 |
| 상품     | Product      | 메뉴에 등록할 수 있는 제품                |
| 비속어    | Profanity    | 메뉴이름에 적합하지 않은 비속어              |
| 이름     | Name         | 메뉴 이름                          |
| 수량     | Quantity     | 메뉴상품에 속한 상품의 수량                |

### 상품

| 한글명 | 영문명            | 설명                                   |
|--|----------------|--------------------------------------|
| 상품 | Product        | 메뉴에 등록할 수 있는 제품                      |
| 가격 | Price          | 상품 가격                                |
| 비속어 | Profanity      | 이름에 적합하지 않은 비속어                      | 
| 이름 | Name      | 상품 이름                      | 
| 메뉴 | Menu      | 상품이 속한 메뉴                      | 
| 메뉴상품 | MenuProduct      | 메뉴가 포함하고 있는 상품                      |
| 노출여부 | Displayed      | 사용자에게 매뉴를 보이게 하거나 숨기게 하는 구분 단위 |

### 배달 주문

| 한글명   | 영문명            | 설명                          |
|-------|----------------|-----------------------------|
| 배달주문   | Order          | 고객에게 라이더를 통해 배달 음식을 전달하는 주문 |
| 주문아이템 | OrderLineItems | 배달 주문에 포함된 메뉴 목록            |
| 주문상태  | OrderStatus    | 배달 주문의 상태                   |
| 대기중   | WAITING        | 배달 주문이 접수 되는것을 기다리는 상태      |
| 접수완료  | ACCEPTED       | 가게에서 배달주문을 받아들였다는 상태        |
| 제공완료  | SERVED         | 라이더에게 음식을 전달한 상태            | 
| 배달중   | DELIVERING     | 고객이 주문한 제품을 배송지로 전달중인 상태    |
| 배달완료  | DELIVERED      | 고객이 주문한 제품을 배송지에서 받았다는 상태   |
| 주문완료  | COMPLETED      | 배달 주문 프로세스가 끝났다는 상태         |
| 라이더   | kitchenriders  | 고객이 주문한 상품을 전달하는 사람         |


### 포장 주문

| 한글명   | 영문명            | 설명                  |
|-------|----------------|---------------------|
| 포장주문  | Order          | 고객이 직접 방문하여 가져가는 주문              |
| 주문아이템 | OrderLineItem  | 포장 주문에 포함된 메뉴       |
| 주문상태  | OrderStatus    | 포장 주문의 상태           |
| 대기중   | WAITING        | 포장 주문이 접수 되는것을 기다리는 상태 |
| 접수완료  | ACCEPTED       | 가게에서 포장 주문을 받아들였다는 상태 |
| 제공완료  | SERVED         | 고객에게 포장된 음식을 전달한 상태 |
| 주문완료  | COMPLETED      | 포장 주문 프로세스가 끝났다는 상태 |

### 매장 주문

| 한글명   | 영문명             | 설명                        |
|-------|-----------------|---------------------------|
| 매장주문  | Order           | 고객이 매장에서 식사하는 주문          |
| 주문아이템 | OrderLineItem   | 매장 주문에 포함된 메뉴             |
| 주문상태  | OrderStatus     | 매장 주문의 상태                 |
| 대기중   | WAITING         | 매장 주문이 접수 되는것을 기다리는 상태    |
| 접수완료  | ACCEPTED        | 가게에서 매장 주문을 받아들였다는 상태     |
| 제공완료  | SERVED          | 고객에게 음식을 전달한 상태           |
| 주문완료  | COMPLETED       | 매장 주문 프로세스가 끝났다는 상태       |
| 테이블   | OrderTable      | 고객이 앉아서 음식을 제공 받을 수 있는 장소 |
| 고객수   | numberOfGuests  | 한 테이블에 앉은 고객 수            |
| 공석여부  | occupied        | 테이블에 고객이 앉았는지 여부          |
| 빈테이블  | EmptyOrderTable | 테이블에 고객이 없는 상태            |


## 모델링

### 메뉴

#### 속성

- 메뉴(Menu)는 이름(Name), 가격(Price), 노출여부(Displayed), 메뉴그룹(MenuGroup), 메뉴상품목록(MenuProducts)를 가진다.
- 메뉴(Menu)의 이름(Name)에 비속어(Profanity)가 포함될 수 없다.
- 메뉴(Menu)의 가격(Price)은 0원 이상이어야 한다.
- 메뉴(Menu)는 메뉴(Menu)가 속해있는 메뉴그룹(MenuGroup)이 반드시 존재해야 한다.
- 메뉴그룹(MenuGroup)은 이름(Name)을 반드시 가진다.
- 메뉴상품(MenuProduct)은 상품(Product)과 수량(Quantity)을 가진다.
- 메뉴상품(MenuProduct)의 상품(Product)은 반드시 존재해야 한다.
- 메뉴상품(MenuProduct)의 수량(Quantity)은 0개 이상이어야 한다.
- 메뉴(Menu)의 가격(Price)은 메뉴상품목록(MenuProducts)에 포함된 상품(Product)들의 가격(Price)의 합보다 작거나 같아야 한다.
- 메뉴(Menu)의 가격(Price)이 메뉴상품목록(MenuProducts)에 포함된 상품(Product)들의 가격(Price)의 합보다 크면 메뉴를 노출할 수 없다.
- 메뉴상품(MenuProduct)에 포함된 상품(Product)의 가격(Price)이 변경됐을 때, 
  메뉴(Menu)의 가격(Price)이 메뉴상품목록(MenuProducts)에 포함된 상품(Product)들의 가격(Price)의 합보다 크면 메뉴를 노출할 수 없다.

#### 행위

- 메뉴(Menu)는 등록할 수 있다.
- 메뉴(Menu)는 가격(Price)를 변경할 수 있다.
- 등록된 메뉴(Menu)를 노출할 수 있다. 
- 등록된 메뉴(Menu)는 숨길 수 있다.
- 등록된 메뉴(Menu)의 목록을 조회할 수 있다.


### 상품

#### 속성

- 상품(Product)는 이름(Name), 가격(Price)을 가진다.
- 상품(Product)의 이름(Name)에 비속어(Profanity)가 포함될 수 없고 빈값이 될 수 없다.
- 상품(Product)의 가격(Price)은 0원 이상의 값을 가진다.
- 상품(Product)의 가격(Price)이 변경됐을 때,
  메뉴(Menu)의 가격(Price)이 메뉴상품목록(MenuProducts)에 포함된 상품(Product)들의 가격(Price)의 합보다 크면 메뉴를 노출할 수 없다.

#### 행위

- 상품(Product)은 등록할 수 있다.
- 상품(Product)은 가격(Price)를 변경할 수 있다.
- 상품(Product) 목록을 조회할 수 있다.

### 배달주문

- `Order`는 식별자와 `OrderStatus`, 주문시간, 배달주소, `OrderLineItems`를 가진다.
- 메뉴가 노출되고 메뉴 가격과 `OrderLineItem` 가격이 같으면 `Order` 생성이 가능하다.
- `Order`는 `WAITING` -> `ACCEPTED` ➜ `SERVED` ➜ `DELIVERING` ➜ `DELIVERED` ➜ `COMPLETED` 순서로 진행된다.
- `Order`가 접수되면 `kitchenriders` 에게 배달을 요청한다.
- `OrderLineItem`는 식별자와 가격, 수량, 메뉴를 가진다.
- `OrderLineItem`의 수량은 0 보다 크거나 같아야 한다.

### 포장주문

- `Order`는 식별자와 `OrderStatus`, 주문 시간, `OrderLineItems`를 가진다.
- 메뉴가 노출되고 메뉴 가격과 `OrderLineItem` 가격이 같으면 `Order` 생성이 가능하다.
- `Order`는 `WAITING` ➜ `ACCEPTED` ➜ `SERVED` ➜ `COMPLETED` 순서로 진행된다.
- `OrderLineItem`는 식별자와 가격, 수량, 메뉴를 가진다.
- `OrderLineItem`의 수량은 0 보다 크거나 같아야 한다.

### 매장주문

#### 속성

- `Order`는 식별자와 `OrderStatus`, 주문 시간, `OrderLineItems`를 가진다.
- 메뉴가 노출되고 메뉴 가격과 `OrderLineItem` 가격이 같으면 `Order` 생성이 가능하다.
- `Order`는 `WAITING` ➜ `ACCEPTED` ➜ `SERVED` ➜ `COMPLETED` 순서로 진행된다.
- `OrderLineItem`는 식별자와 가격, 수량, 메뉴를 가진다.
- `OrderLineItem`의 수량은 0 보다 크거나 같아야 한다.


#### 테이블

- `OrderTable`은 식별자와 이름, `numberOfGuests`, `occupied` 를 가진다.
- `OrderTable`은 `Order`가 완료되면 `EmptyOrderTable`이 된다.
