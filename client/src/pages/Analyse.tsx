import React from "react";
import { useMancalaGame } from "../contexts/MancalaGameContext";
import { Play } from "./Play";
import { Start } from "./Start";

export const Analyse = () => {
    const { gameState } = useMancalaGame();
    return gameState ? <Analyse /> : <Start />;
};
