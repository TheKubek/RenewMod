package net.kubek.renew.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.kubek.renew.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagEntry;
import net.minecraft.registry.tag.TagKey;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.STAFF_OF_DOMINANCE)
                .pattern(" # ")
                .pattern("XDX")
                .pattern(" X ")
                .input('#',ModItems.ORB_OF_DOMINANCE)
                .input('X', Items.NETHER_STAR)
                .input('D', Items.DRAGON_EGG)
                .criterion(hasItem(ModItems.ORB_OF_DOMINANCE),conditionsFromItem(ModItems.ORB_OF_DOMINANCE))
                .criterion(hasItem(Items.NETHER_STAR),conditionsFromItem(Items.NETHER_STAR))
                .criterion(hasItem(Items.DRAGON_EGG),conditionsFromItem(Items.DRAGON_EGG))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.DANCER_SWORD)
                .pattern("NXI")
                .pattern("GSG")
                .pattern("IXN")
                .input('S',Items.STICK)
                .input('X', Items.NETHERITE_SCRAP)
                .input('I', Items.IRON_INGOT)
                .input('N', Items.GOLD_NUGGET)
                .input('G', Items.GOLD_INGOT)
                .criterion(hasItem(Items.STICK),conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.NETHERITE_SCRAP),conditionsFromItem(Items.NETHERITE_SCRAP))
                .criterion(hasItem(Items.IRON_INGOT),conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.GOLD_NUGGET),conditionsFromItem(Items.GOLD_NUGGET))
                .criterion(hasItem(Items.GOLD_INGOT),conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.WOODEN_CUTLASS)
                .pattern(" X ")
                .pattern(" X ")
                .pattern("XS ")
                .input('S',Items.STICK)
                .input('X', ItemTags.PLANKS)
                .criterion(hasItem(Items.STICK),conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.STONE_CUTLASS)
                .pattern(" X ")
                .pattern(" X ")
                .pattern("XS ")
                .input('S',Items.STICK)
                .input('X', ItemTags.STONE_TOOL_MATERIALS)
                .criterion(hasItem(Items.COBBLESTONE),conditionsFromItem(Items.COBBLESTONE))
                .criterion(hasItem(Items.COBBLED_DEEPSLATE),conditionsFromItem(Items.COBBLED_DEEPSLATE))
                .criterion(hasItem(Items.BASALT),conditionsFromItem(Items.BASALT))
                .offerTo(recipeExporter);
        registerCutlassCrafting(Items.IRON_INGOT,ModItems.IRON_CUTLASS,recipeExporter);
        registerCutlassCrafting(Items.GOLD_INGOT,ModItems.GOLDEN_SCYTHE,recipeExporter);
        registerCutlassCrafting(Items.DIAMOND,ModItems.DIAMOND_SCYTHE,recipeExporter);
        offerNetheriteUpgradeRecipe(recipeExporter,ModItems.DIAMOND_CUTLASS,RecipeCategory.COMBAT,ModItems.NETHERITE_CUTLASS);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.WOODEN_SCYTHE)
                .pattern("XX ")
                .pattern(" #X")
                .pattern(" # ")
                .input('X',ItemTags.PLANKS)
                .input('#',Items.STICK)
                .criterion(hasItem(Items.STICK),conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);
    ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.STONE_SCYTHE)
                .pattern("XX ")
                .pattern(" #X")
                .pattern(" # ")
                .input('X',ItemTags.STONE_TOOL_MATERIALS)
                .input('#',Items.STICK)
                .criterion(hasItem(Items.COBBLESTONE),conditionsFromItem(Items.COBBLESTONE))
                .criterion(hasItem(Items.COBBLED_DEEPSLATE),conditionsFromItem(Items.COBBLED_DEEPSLATE))
                .criterion(hasItem(Items.BASALT),conditionsFromItem(Items.BASALT))
                .offerTo(recipeExporter);
    registerScytheCrafting(Items.IRON_INGOT,ModItems.IRON_SCYTHE,recipeExporter);
    registerScytheCrafting(Items.GOLD_INGOT,ModItems.GOLDEN_SCYTHE,recipeExporter);
    registerScytheCrafting(Items.DIAMOND,ModItems.DIAMOND_SCYTHE,recipeExporter);
    offerNetheriteUpgradeRecipe(recipeExporter,ModItems.DIAMOND_SCYTHE,RecipeCategory.COMBAT,ModItems.NETHERITE_SCYTHE);
    }
    private static void registerScytheCrafting(Item input, Item output,RecipeExporter recipeExporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output)
                .pattern("XX ")
                .pattern(" #X")
                .pattern(" # ")
                .input('X',input)
                .input('#',Items.STICK)
                .criterion(hasItem(input),conditionsFromItem(input))
                .offerTo(recipeExporter);

    }
    private static void registerCutlassCrafting(Item input, Item output, RecipeExporter recipeExporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,output)
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" #X")
                .input('X',input)
                .input('#',Items.STICK)
                .criterion(hasItem(input),conditionsFromItem(input))
                .offerTo(recipeExporter);
    }

}
