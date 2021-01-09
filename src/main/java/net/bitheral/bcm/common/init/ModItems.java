package net.bitheral.bcm.common.init;

import net.bitheral.bcm.Reference;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MOD_ID);

    public static final RegistryObject<Item> CPU_ITEM = ITEMS.register("cpu", () ->
            new Item(new Item.Properties().group(ModGroups.GROUP)));

    public static final RegistryObject<Item> RAM_ITEM = ITEMS.register("ram", () ->
            new Item(new Item.Properties().group(ModGroups.GROUP)));

    public static final RegistryObject<Item> MOBO_ITEM = ITEMS.register("motherboard", () ->
            new Item(new Item.Properties().group(ModGroups.GROUP)));

    public static final RegistryObject<Item> CASE_ITEM = ITEMS.register("chassis", () ->
            new Item(new Item.Properties().group(ModGroups.GROUP)));

    public static final RegistryObject<Item> HDD_ITEM = ITEMS.register("hdd", () ->
            new Item(new Item.Properties().group(ModGroups.GROUP)));

    public static final RegistryObject<Item> SDD_ITEM = ITEMS.register("sdd", () ->
            new Item(new Item.Properties().group(ModGroups.GROUP)));

    public static final RegistryObject<Item> GPU_ITEM = ITEMS.register("gpu", () ->
            new Item(new Item.Properties().group(ModGroups.GROUP)));

    public static final RegistryObject<BlockItem> COMPUTER_ITEM = ITEMS.register("computer", () ->
            new BlockItem(ModBlocks.COMPUTER.get(), new Item.Properties().group(ModGroups.GROUP)));
}
