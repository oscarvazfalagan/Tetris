/*
 * Copyright (C) 2025 Antonio de Andrés Lema
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package tetris;

import java.awt.Color;

/**
 * Clase que implementa a peza cadrada do xogo do Tetris
 *
 * @author Profe de Programación
 */

public class Piece {

    /**
     * Referenza ao obxecto xogo
     */
    private Game game;

    /**
     * Referenzas aos catro cadrados que forman a peza
     */
    private Square a, b, c, d;

    /**
     * Construtor da clase, que crea os catro cadrados que forman a peza
     *
     * @param game Referenza á partida actual
     */
    public Piece(Game game) {
        this.game = game;
        a = new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, 0, Color.BLUE, game);
        b = new Square(Game.MAX_X / 2, 0, Color.BLUE, game);
        c = new Square(Game.MAX_X / 2 - Game.SQUARE_SIDE, Game.SQUARE_SIDE,Color.BLUE, game);
        d = new Square(Game.MAX_X / 2, Game.SQUARE_SIDE, Color.BLUE, game);
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Square getA() {
        return a;
    }

    public void setA(Square a) {
        this.a = a;
    }

    public Square getB() {
        return b;
    }

    public void setB(Square b) {
        this.b = b;
    }

    public Square getC() {
        return c;
    }

    public void setC(Square c) {
        this.c = c;
    }

    public Square getD() {
        return d;
    }

    public void setD(Square d) {
        this.d = d;
    }

    /**
     * Move a ficha á dereita se é posible
     *
     * @return true se o movemento da ficha é posible, se non false
     */
    public boolean moveRight() {
        int x = Math.max(Math.max(b.getX(), a.getX()),Math.max(c.getX(), d.getX()));
        boolean canMove = false;
        if(game.isValidPosition(x+20, 0)){
            a.setX(a.getX()+20);
            b.setX(b.getX()+20);
            c.setX(c.getX()+20);
            d.setX(d.getX()+20);
            canMove=true;
        }
        return canMove;
    }

    /**
     * Move a ficha á esquerda se é posible
     *
     * @return true se o movemento da ficha é posible, se non false
     */
    public boolean moveLeft() {
        //Le establecemos a x el valor mas pequeño que 
        int x = Math.min(Math.min(b.getX(), a.getX()),Math.min(c.getX(), d.getX()));
        boolean canMove = false;
        if(game.isValidPosition(x-20, 0)){
            a.setX(a.getX()-20);
            b.setX(b.getX()-20);
            c.setX(c.getX()-20);
            d.setX(d.getX()-20);
            canMove=true;
        }
        return canMove;
    }


    /**
     * Move a ficha a abaixo se é posible
     *
     * @return true se o movemento da ficha é posible, se non false
     */
    public boolean moveDown() {
        //Le establecemos a y el valor mas pequeño que haya en los cuadrados
        int y = Math.max(Math.max(b.getY(), a.getY()),Math.max(c.getY(), d.getY()));
        boolean canMove = false;
        if(game.isValidPosition(0, y + 20)){
            a.setY(a.getY()+20);
            b.setY(b.getY()+20);
            c.setY(c.getY()+20);
            d.setY(d.getY()+20);
            canMove=true;
        }
        return canMove;
    }

    /**
     * Rota a ficha se é posible
     *
     * @return true se o movemento da ficha é posible, se non false
     */
    public boolean rotate() {
        // A rotación da ficha cadrada non supón ningunha variación na ficha,
        // por iso simplemente devolvemos true
        return true;
    }

}
