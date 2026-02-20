package net.kubek.renew.entity.client;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.kubek.renew.Renew;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class CorruptedEnchanterEyesFeatureRender extends EyesFeatureRenderer<CorruptedEnchanterRenderState, CorruptedEnchanterModel> {
    private static final RenderLayer SKIN = RenderLayer.getEyes(Identifier.of(Renew.MOD_ID,"textures/entity/corrupted_enchanter_eyes.png"));


    public CorruptedEnchanterEyesFeatureRender(FeatureRendererContext<CorruptedEnchanterRenderState, CorruptedEnchanterModel> context) {
        super(context);
    }


    @Override
    public RenderLayer getEyesTexture() {
        return SKIN;
    }



}
