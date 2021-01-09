package net.bitheral.bcm.common.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModGroups {

    public static final ItemGroup GROUP = new ItemGroup("bcm.tab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.CPU_ITEM.get());
        }
    };
}
