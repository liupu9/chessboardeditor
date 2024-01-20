package com.chessboard.editor;

import com.almasb.fxgl.app.GameSettings;
import com.chessboard.editor.constants.GameConst;
import com.chessboard.editor.gameworld.FrontlineService;
import com.chessboard.editor.gameworld.PropertyKey;
import com.chessboard.editor.utils.LogUtil;
import com.chessboard.editor.xgamescenes.Index;
import com.chessboard.editor.xgamescenes.PlatformGame;
import com.chessboard.editor.xgamescenes.RogueLikeGame;
import com.whitewoodcity.fxgl.app.GameApplication;
import com.whitewoodcity.fxgl.app.ReplaceableGameSceneBuilder;
import com.whitewoodcity.fxgl.dsl.FXGL;
import com.whitewoodcity.fxgl.service.ReplaceableGameScene;
import com.whitewoodcity.fxgl.service.XGameScene;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

/**
 * 游戏APP,配置
 *
 * @author liupu
 */
public class GameApp extends GameApplication implements GameConst {

  public GameApp(String initSceneName, ReplaceableGameSceneBuilder sceneBuilder) {
    super(initSceneName, sceneBuilder);
  }

  public GameApp(String initSceneName) {
    super(initSceneName);
  }

  @Override
  @SuppressWarnings("all")
  protected void initSettings(GameSettings settings) {
    this.logoString = APP_NAME;
    settings.setTitle(logoString);
    settings.setVersion(APP_VERSION);
    initAppWidthHeight(settings);
    settings.setMainMenuEnabled(true);
    settings.setGameMenuEnabled(true);
    settings.setFontUI(FONT_UI);
  }

  @Override
  public Object push(String sceneName, Object... parameters) {
    var app = super.push(sceneName, parameters);

    if (app instanceof ReplaceableGameScene) {
      FXGL.set(PropertyKey.SCENE_NAME, sceneName);
    }

    return app;
  }

  /**
   * 获取游戏场景
   *
   * @param sceneName 场景名
   * @param parameters 参数
   * @return 包含的游戏场景
   */
  @Override
  protected XGameScene getGameSceneByName(String sceneName, Object... parameters) {
    LogUtil.info("getGameSceneByName : " + sceneName);
    return switch (sceneName) {
      case Index.SCENE_NAME ->  new Index();
      case PlatformGame.SCENE_NAME -> new PlatformGame();
      case RogueLikeGame.SCENE_NAME -> new RogueLikeGame();
      default -> throw new RuntimeException("Wrong XGameScene type");
    };
  }

  public FrontlineService getFrontlineService() {
    var app = gameScenes.getLast();
    if (app instanceof FrontlineService frontlineService)
      return frontlineService;
    else return null;
  }

  private void initAppWidthHeight(GameSettings settings) {
    //主屏幕大小
    Rectangle2D bounds = Screen.getPrimary().getBounds();
    double screenWidth = bounds.getWidth();
    double screenHeight = bounds.getHeight();
    int height = Math.min(APP_HEIGHT, (int)screenHeight);
    int width = (int) (screenWidth / screenHeight * APP_HEIGHT);
    LogUtil.info("screenWidth:" + screenWidth + ", screenHeight:" + screenHeight + ", appWidth: " + width +
            ", appHeight: " + height);
    settings.setWidth(width);
    settings.setHeight(height);
  }

//  private void init2(GameSettings settings) {
//    settings.setSceneFactory(new SceneFactory() {
//      @Override
//      public LoadingScene newLoadingScene() {
//        return new LoadingScene(getLoadingBackgroundFill(), getTheme().textColor);
//      }
//    });
//  }
}