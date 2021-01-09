package net.bitheral.bcm.common.block;

import net.bitheral.bcm.util.RotationHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import java.util.Map;

public class BlockComputer extends Block {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public static final IntegerProperty PROGRESS = IntegerProperty.create("progress", 0, 13);

    public static final Map<Direction, VoxelShape> FLAT_SHAPE_MAP = RotationHelper.createYRotationMap(VoxelShapes.or(
            Block.makeCuboidShape(0, 0, 0, 16, 2, 16)
    ));

    public static final Map<Direction, VoxelShape> FACING_TO_SHAPE_MAP = RotationHelper.createYRotationMap(VoxelShapes.or(
            Block.makeCuboidShape(0, 0, 10, 16, 16, 16)
//            Block.makeCuboidShape(6, 13, 0, 10, 14, 1),
//            Block.makeCuboidShape(6, 2, 0, 10, 3, 1),
//            Block.makeCuboidShape(13, 6, 0, 14, 10, 1),
//            Block.makeCuboidShape(2, 6, 0, 3, 10, 1),
//            Block.makeCuboidShape(3, 10, 0, 4, 12, 1),
//            Block.makeCuboidShape(3, 4, 0, 4, 6, 1),
//            Block.makeCuboidShape(12, 4, 0, 13, 6, 1),
//            Block.makeCuboidShape(12, 10, 0, 13, 12, 1),
//            Block.makeCuboidShape(10, 12, 0, 12, 13, 1),
//            Block.makeCuboidShape(4, 12, 0, 6, 13, 1),
//            Block.makeCuboidShape(10, 3, 0, 12, 4, 1),
//            Block.makeCuboidShape(4, 3, 0, 6, 4, 1),
//            Block.makeCuboidShape(3, 6, 0.25, 13, 10, 0.75),
//            Block.makeCuboidShape(4, 10, 0.25, 12, 12, 0.75),
//            Block.makeCuboidShape(4, 4, 0.25, 12, 6, 0.75),
//            Block.makeCuboidShape(6, 3, 0.25, 10, 4, 0.75),
//            Block.makeCuboidShape(6, 12, 0.25, 10, 13, 0.75),
//            Block.makeCuboidShape(3, 14, 0.5, 4, 15, 1),
//            Block.makeCuboidShape(1, 14, 0.5, 2, 15, 1)
           ));

    public BlockComputer(Properties properties) {
        super(properties);
        properties.hardnessAndResistance(10, 50);
        this.setDefaultState(this.getStateContainer().getBaseState()
                .with(FACING, Direction.NORTH)
                .with(PROGRESS, 0)
                .with(BlockStateProperties.POWERED, Boolean.valueOf(false))
        );
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        if(state.get(PROGRESS) >= 7) {
            return FACING_TO_SHAPE_MAP.get(state.get(FACING));
        } else {
            return FLAT_SHAPE_MAP.get(state.get(FACING));
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, IWorld world, BlockPos pos, Rotation direction) {
        return rotate(state, direction);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return rotate(state, mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        builder.add(PROGRESS);
        builder.add(BlockStateProperties.POWERED);
    }

    @Override
    public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
        super.onBlockClicked(state, worldIn, pos, player);
        player.jump();
    }
}
