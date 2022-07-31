package ru.cft.hireofgoods.repository.model;

public class ItemEntity {
    private Long itemId;

    private String name;

    private Long ownerId;

    //@Column(name = "amount", nullable = false)
    //private String amount;

    public ItemEntity(){}

    public ItemEntity(Long itemId, String name, Long ownerId) {
        this.itemId = itemId;
        this.name = name;
        this.ownerId = ownerId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
