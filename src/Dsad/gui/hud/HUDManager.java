    package Dsad.gui.hud;

    import com.google.common.collect.Sets;
    import Dsad.event.EventManager;
    import Dsad.event.EventTarget;
    import Dsad.event.impl.RenderEvent;
    import net.minecraft.client.Minecraft;
    import net.minecraft.client.gui.GuiChat;
    import net.minecraft.client.gui.inventory.GuiContainer;
    import java.util.Collection;
    import java.util.Set;

    public class HUDManager {

        public HUDManager() {
        }

        private static HUDManager instance = null;

        public static HUDManager getInstance() {
            if (instance != null) {
                return instance;
            }
            instance = new HUDManager();
            EventManager.register(instance);

            return instance;
        }

        private Set<IRenderer> registeredRenderers = Sets.newHashSet();
        private Minecraft mc = Minecraft.getMinecraft();

        public void register(IRenderer... renderers) {
            for (IRenderer render : renderers) {
                this.registeredRenderers.add(render);
            }
        }

        public void unregister(IRenderer... renderers) {
            for (IRenderer render : renderers) {
                this.registeredRenderers.remove(render);
            }
        }

        public Collection<IRenderer> getRegisterRenderers() {
            return Sets.newHashSet(registeredRenderers);
        }

        public void openConfigScreen() {
            Minecraft.getMinecraft().displayGuiScreen(new HUDConfigScreen(this));
        }

        @EventTarget
        public void onRender(RenderEvent event) {
            if (mc.currentScreen == null || mc.currentScreen instanceof GuiChat || mc.currentScreen instanceof GuiContainer) {
                for (IRenderer renderer : registeredRenderers) {
                    callRenderer(renderer);
                }
            }
        }

        private void callRenderer(IRenderer renderer) {
            if (!renderer.isEnabled()) {
                return;
            }
            ScreenPosition pos = renderer.load();

            if (pos == null) {
                pos = ScreenPosition.fromRelativePosition(0.5, 0.5);
            }
            renderer.render(pos);
        }
    }
