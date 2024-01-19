package com.chessboard.editor.gameworld.collisionhandler;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.CollisionHandler;
import com.chessboard.editor.gameworld.Type;

public class TranslucentCollisionHandler extends CollisionHandler {
  public TranslucentCollisionHandler(Type character, Type unit) {
    super(character, unit);
  }

  @Override
  protected void onCollisionBegin(Entity character, Entity unit) {
    super.onCollisionBegin(character, unit);

    if(unit.getZIndex() > character.getZIndex()){
      unit.setOpacity(.5);
    }
  }

  @Override
  protected void onCollisionEnd(Entity character, Entity unit) {
    super.onCollisionEnd(character, unit);
    unit.setOpacity(1);
  }
}
