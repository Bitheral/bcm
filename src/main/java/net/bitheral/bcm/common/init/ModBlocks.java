package net.bitheral.bcm.common.init;

import net.bitheral.bcm.Reference;
import net.bitheral.bcm.common.block.BlockComputer;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Reference.MOD_ID);

    public static final RegistryObject<Block> COMPUTER = BLOCKS.register("computer", () ->
            new BlockComputer(AbstractBlock.Properties.create(Material.IRON, MaterialColor.GRAY)));
}
