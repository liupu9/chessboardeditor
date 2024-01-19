package com.chessboard.editor.gameworld.entity.components;

import com.almasb.fxgl.entity.Entity;

@FunctionalInterface
public interface EntityRunnable {
  void run(Entity entity);
}
