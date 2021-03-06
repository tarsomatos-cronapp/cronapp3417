package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class UserManager {

public static final int TIMEOUT = 300;

/**
 *
 * @param param_Entidade
 * @return Var
 */
// UserManager
public static Var BeforeInsert(Var param_Entidade) throws Exception {
 return new Callable<Var>() {

   // param
   private Var Entidade = param_Entidade;
   // end

   public Var call() throws Exception {

    Entidade =
    Var.valueOf(Normalize(Entidade));
    return Entidade;
   }
 }.call();
}

/**
 *
 * @param param_Entidade
 * @return Var
 */
// UserManager
public static Var BeforeUpdate(Var param_Entidade) throws Exception {
 return new Callable<Var>() {

   // param
   private Var Entidade = param_Entidade;
   // end

   public Var call() throws Exception {

    Entidade =
    Var.valueOf(Normalize(Entidade));
    return Entidade;
   }
 }.call();
}

/**
 *
 * @param Entidade
 * @return Var
 */
// Descreva esta função...
public static Var Normalize(Var Entidade) throws Exception {
 return new Callable<Var>() {

   private Var userName = Var.VAR_NULL;
   private Var email = Var.VAR_NULL;

   public Var call() throws Exception {

    userName =
    cronapi.text.Operations.normalize(
    cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("userName")));

    email =
    cronapi.text.Operations.normalize(
    cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("email")));

    cronapi.object.Operations.setObjectField(Entidade, Var.valueOf("normalizedUserName"), userName);

    cronapi.object.Operations.setObjectField(Entidade, Var.valueOf("normalizedEmail"), email);
    return Entidade;
   }
 }.call();
}

/**
 *
 * @param toAddress
 * @param token
 * @return Var
 */
// Descreva esta função...
public static Var sendResetPasswordEmail(Var toAddress, Var token) throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {

    cronapi.email.Operations.sendEmail(
    Var.VAR_NULL, toAddress,
    Var.VAR_NULL,
    Var.VAR_NULL,
    cronapi.i18n.Operations.translate(Var.valueOf("ResetPasswordEmailSubject")),
    Var.valueOf(
    cronapi.i18n.Operations.translate(Var.valueOf("ResetPasswordEmailBody")).toString() +
    cronapi.screen.Operations.getHeader(
    Var.valueOf("Origin")).toString() +
    Var.valueOf("/#/public/reset-password?token=").toString() +
    token.toString()),
    Var.VAR_NULL,
    Var.VAR_NULL,
    Var.VAR_NULL,
    Var.VAR_NULL,
    Var.VAR_NULL,
    Var.VAR_NULL,
    Var.valueOf("TLS"));
    return Var.VAR_NULL;
   }
 }.call();
}

}

