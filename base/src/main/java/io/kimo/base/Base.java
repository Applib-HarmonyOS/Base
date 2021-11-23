package io.kimo.base;


public interface Base {

    /**
     * Main contract between the harmony classes
     */
    interface HarmonyComponent<P extends Presenter>{
        /* return your component's layout resource */
        int getLayoutResource();

        /* call all your mapping methods in here (e.g findComponentById) */
        void mapUI(ohos.agp.components.Component component);

        /* configure everything related with your mapped components (adapters, click listeners, etc) */
        void configureUI();

        /* build up your presenter with all its necessary dependencies in here */
        P injectDependencies();
    }

    interface Component<P extends Presenter> extends HarmonyComponent<P> {
        /* getter to the component's presenter */
        P getPresenter();
    }

    interface Presenter {
        void createComponent();
        void destroyComponent();
    }
}
