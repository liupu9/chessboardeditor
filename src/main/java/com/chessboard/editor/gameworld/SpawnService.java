package com.chessboard.editor.gameworld;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.SpawnData;
import com.chessboard.editor.gameworld.entity.characters.ClancyComponent;
import com.chessboard.editor.gameworld.entity.Launcher;
import com.chessboard.editor.gameworld.entity.ammo.Bullet;
import com.chessboard.editor.gameworld.entity.ammo.LauncherMissile;

public interface SpawnService extends com.whitewoodcity.fxgl.service.SpawnService<Type> {
  @Override
  default Entity build(Type type, SpawnData data) {
    return switch (type) {
      case CLANCY -> ClancyComponent.of(data);
      case LAUNCHER -> Launcher.of(data);
      case BULLET -> Bullet.of(data);
      case LAUNCHER_MISSILE -> LauncherMissile.of(data);
      default -> throw new RuntimeException("Type "+type+" is not supported yet.");
    };
  }
}
