package net.kubek.renew.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.kubek.renew.item.ModItems;
import net.kubek.renew.item.OrbOfDominanceParts;
import net.kubek.renew.item.OrbOfDominanceTools;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
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
                .criterion(hasItem(Items.NETHERITE_SCRAP),conditionsFromItem(Items.NETHERITE_SCRAP))
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
        registerCutlassCrafting(Items.GOLD_INGOT,ModItems.GOLDEN_CUTLASS,recipeExporter);
        registerCutlassCrafting(Items.DIAMOND,ModItems.DIAMOND_CUTLASS,recipeExporter);
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
    ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.COSMETIC_DICE)
            .pattern("SWS")
            .pattern("WLW")
            .pattern("SWS")
            .input('W',ItemTags.WOOL)
            .input('S',Items.STRING)
            .input('L',Items.LEATHER)
            .criterion(hasItem(Items.LEATHER),conditionsFromItem(Items.LEATHER))
            .offerTo(recipeExporter);
    registerScytheCrafting(Items.IRON_INGOT,ModItems.IRON_SCYTHE,recipeExporter);
    registerScytheCrafting(Items.GOLD_INGOT,ModItems.GOLDEN_SCYTHE,recipeExporter);
    registerScytheCrafting(Items.DIAMOND,ModItems.DIAMOND_SCYTHE,recipeExporter);

    ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,OrbOfDominanceTools.ORB_OF_DOMINANCE_SWORD)
            .pattern("N")
            .pattern("N")
            .pattern("O")
            .input('N',Items.NETHERITE_INGOT)
            .input('O', OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_ONE)
            .criterion(hasItem(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_ONE),conditionsFromItem(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_ONE))
            .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,OrbOfDominanceTools.ORB_OF_DOMINANCE_AXE)
                .pattern("ON")
                .pattern("SN")
                .pattern("S ")
                .input('N',Items.NETHERITE_INGOT)
                .input('S',Items.STICK)
                .input('O', OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_TWO)
                .criterion(hasItem(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_TWO),conditionsFromItem(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_TWO))
                .offerTo(recipeExporter);
    ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,OrbOfDominanceTools.ORB_OF_DOMINANCE_PICKAXE)
                .pattern("NON")
                .pattern(" S ")
                .pattern(" S ")
                .input('N',Items.NETHERITE_INGOT)
                .input('S',Items.STICK)
                .input('O', OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_THREE)
                .criterion(hasItem(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_THREE),conditionsFromItem(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_THREE))
                .offerTo(recipeExporter);
ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,OrbOfDominanceTools.ORB_OF_DOMINANCE_SHOVEL)
                .pattern("O")
                .pattern("N")
                .pattern("S")
                .input('N',Items.NETHERITE_INGOT)
                .input('S',Items.STICK)
                .input('O', OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_FOUR)
                .criterion(hasItem(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_FOUR),conditionsFromItem(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_FOUR))
                .offerTo(recipeExporter);
ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,OrbOfDominanceTools.ORB_OF_DOMINANCE_HOE)
                .pattern("ON")
                .pattern("N ")
                .pattern("S ")
                .input('N',Items.NETHERITE_INGOT)
                .input('S',Items.STICK)
                .input('O', OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_FIVE)
                .criterion(hasItem(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_FIVE),conditionsFromItem(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_FIVE))
                .offerTo(recipeExporter);
ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.ORB_OF_DOMINANCE_HELMET)
                .pattern("NON")
                .pattern("N N")
                .input('N',Items.NETHERITE_INGOT)
                .input('O',OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_SIX)
                .criterion(hasItem(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_SIX),conditionsFromItem(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_SIX))
                .offerTo(recipeExporter);
ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.ORB_OF_DOMINANCE_CHESTPLATE)
                .pattern("N N")
                .pattern("NON")
                .pattern("NNN")
                .input('N',Items.NETHERITE_INGOT)
                .input('O',OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_SEVEN)
                .criterion(hasItem(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_SEVEN),conditionsFromItem(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_SEVEN))
                .offerTo(recipeExporter);
ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.ORB_OF_DOMINANCE_LEGGINGS)
                .pattern("NON")
                .pattern("N N")
                .pattern("N N")
                .input('N',Items.NETHERITE_INGOT)
                .input('O',OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_EIGHT)
                .criterion(hasItem(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_EIGHT),conditionsFromItem(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_EIGHT))
                .offerTo(recipeExporter);
ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.ORB_OF_DOMINANCE_BOOTS)
                .pattern("N N")
                .pattern("NON")
                .input('N',Items.NETHERITE_INGOT)
                .input('O',OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_NINE)
                .criterion(hasItem(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_NINE),conditionsFromItem(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_NINE))
                .offerTo(recipeExporter);
ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,OrbOfDominanceTools.ORB_OF_DOMINANCE_CUTLASS)
                .pattern("N ")
                .pattern("N ")
                .pattern("SO")
                .input('N',Items.NETHERITE_INGOT)
                .input('S',Items.STICK)
                .input('O', OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_ONE)
                .criterion(hasItem(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_ONE),conditionsFromItem(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_ONE))
                .offerTo(recipeExporter);
ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,OrbOfDominanceTools.ORB_OF_DOMINANCE_SCYTHE)
                .pattern("NN ")
                .pattern(" ON")
                .pattern(" S ")
                .input('N',Items.NETHERITE_INGOT)
                .input('S',Items.STICK)
                .input('O', OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_FIVE)
                .criterion(hasItem(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_FIVE),conditionsFromItem(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_FIVE))
                .offerTo(recipeExporter);
ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DOMINANCE_DICE)
                .pattern("CBC")
                .pattern("BNB")
                .pattern("CBC")
                .input('C',Items.COAL_BLOCK)
                .input('B',Items.BLAZE_POWDER)
                .input('N',Items.NETHER_STAR)
                .criterion(hasItem(Items.BLAZE_POWDER),conditionsFromItem(Items.BLAZE_POWDER))
                .offerTo(recipeExporter);
ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GLACIER_SCYTHE)
                .pattern("BB ")
                .pattern(" SB")
                .pattern(" B ")
                .input('B',Items.BLUE_ICE)
                .input('S',ModItems.ENCHANTER_SCYTHE)
                .criterion(hasItem(ModItems.ENCHANTER_SCYTHE),conditionsFromItem(ModItems.ENCHANTER_SCYTHE))
                .offerTo(recipeExporter);


ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.ORB_OF_DOMINANCE)
                .input(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_ONE)
                .input(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_TWO)
                .input(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_THREE)
                .input(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_FOUR)
                .input(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_FIVE)
                .input(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_SIX)
                .input(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_SEVEN)
                .input(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_EIGHT)
                .input(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_NINE)
                .criterion(hasItem(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_ONE),conditionsFromItem(OrbOfDominanceParts.ORB_OF_DOMINANCE_PART_ONE));
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
