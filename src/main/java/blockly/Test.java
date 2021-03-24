package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Test {

public static final int TIMEOUT = 300;

/**
 *
 * @return Var
 */
// Test
public static Var execute() throws Exception {
 return new Callable<Var>() {

   private Var item = Var.VAR_NULL;

   public Var call() throws Exception {

    item =
    Var.valueOf(
    cronapi.io.Operations.fileTempDir().toString() +
    Var.valueOf("/teste.pdf").toString());

    System.out.println(item.getObjectAsString());

    item =
    cronapi.report.Operations.generateReport(
    Var.valueOf("reports/test.report"), item, cronapi.list.Operations.newList());

    cronapi.io.Operations.startDownload(item,
    Var.valueOf("teste.pdf"));
    return Var.VAR_NULL;
   }
 }.call();
}

}

