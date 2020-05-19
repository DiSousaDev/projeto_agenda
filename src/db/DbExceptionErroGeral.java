/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/**
 *
 * @author ederc
 */
public class DbExceptionErroGeral extends RuntimeException{
   
    public DbExceptionErroGeral(String msg){
        super(msg);
    }
}
