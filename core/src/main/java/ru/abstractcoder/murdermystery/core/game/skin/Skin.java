package ru.abstractcoder.murdermystery.core.game.skin;

import com.comphenix.protocol.wrappers.WrappedSignedProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.mojang.authlib.properties.Property;
import org.bukkit.inventory.ItemStack;
import ru.abstractcoder.benioapi.item.ItemUtils;

import java.util.List;
import java.util.Random;

public class Skin {

    private final String texture;
    private final String signature;
    private final Property property;
    private final WrappedSignedProperty wrappedProperty;

    private ItemStack skull = null;


    @JsonCreator
    public Skin(String texture, String signature) {
        this.texture = texture;
        this.signature = signature;

        property = new Property("textures", texture, signature);
        wrappedProperty = WrappedSignedProperty.fromHandle(property);
    }

    public String getTexture() {
        return texture;
    }

    public String getSignature() {
        return signature;
    }

    public Property getProperty() {
        return property;
    }

    public WrappedSignedProperty getWrappedProperty() {
        return wrappedProperty;
    }

    public ItemStack getSkull() {
        if (skull == null) {
            skull = ItemUtils.createSkull(property);
        }
        return skull;
    }

}