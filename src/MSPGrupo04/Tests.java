package MSPGrupo04;

import java.util.Calendar;
import java.util.Date;

public class Tests {
    public static void main() {
        runTestes();
    }

    private static boolean test_calcularNumSemanas(Date arg1, Date arg2, int expectedRes) {
        return Main.calcularNumSemanas(arg1, arg2) == expectedRes;
    }

    private static boolean test_compararMatrizes(double[][] matriz) {
        return Matrizes.compararMatrizes(matriz, matriz);
    }

    private static boolean test_multiplicarMatrizes(double[][] matriz1, double[][] matriz2, double[][] expectedRes) {
        double[][] result = Matrizes.multiplicarMatrizes(matriz1, matriz2);
        return Matrizes.compararMatrizes(result, expectedRes);
    }

    private static boolean test_elevarMatriz(double[][] matriz, long nth, double[][] expectedRes) {
        double[][] result = Matrizes.elevarMatriz(matriz, nth);
        return Matrizes.compararMatrizes(result, expectedRes);
    }

   /* private static boolean test_trocarPosicoesMatriz(double[][] matriz, double[][] expectedRes) {
        double[][] result = Matrizes.trocarPosicoesMatriz(matriz);
        return Matrizes.compararMatrizes(result, expectedRes);
    } */

    private static boolean test_matrizInversaL(double[][] matriz, double[][] expectedRes) {
        double[][] result = Matrizes.inversaL(matriz);
        return Matrizes.compararMatrizes(result, expectedRes);
    }

    private static boolean test_matrizInversaU(double[][] matriz, double[][] expectedRes) {
        double[][] result = Matrizes.inversaU(matriz);
        return Matrizes.compararMatrizes(result, expectedRes);
    }

    private static boolean test_preencherDiagonalMatriz(double num, int tamanho, double[][] expectedRes) {
        double[][] res = Matrizes.preencherDiagonalMatriz(num, tamanho);
        return Matrizes.compararMatrizes(res, expectedRes);
    }

    private static boolean test_decomposicaoCrout(double[][] matrizL, double[][] matrizU, double[][] matriz,
            double[][] croutL_expectedRes, double[][] croutU_expectedRes) {
        Matrizes.decomposicaoCrout(matrizL, matrizU,matriz);
        return Matrizes.compararMatrizes(matrizL, croutL_expectedRes)
                && Matrizes.compararMatrizes(matrizU, croutU_expectedRes);
    }

    private static boolean test_calcularDiasEntreInvervalo(String[] intervalo, long expectedRes) {
        return Main.calcularDiasEntreIntervalo(intervalo) == expectedRes;
    }

    private static boolean test_validarDatas(String[] datas, boolean[] expectedRes) {
        boolean flag = true;
        for (int i = 0; i < datas.length; i++) {
            if ((Main.verificarData1(datas[i]) || Main.verificarData2(datas[i])) != expectedRes[i]) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private static boolean test_subtrairIdentidadeComMatriz(double[][] matriz1, double[][] expectedRes) {
        double[][] res = Matrizes.subtrairIdentidadeComMatriz(matriz1);
        return Matrizes.compararMatrizes(res, expectedRes);
    }

    private static boolean test_ultimoDiaMesValido(Date[] datas, Date[] expectedRes) {
        boolean flag = true;
        for (int i = 0; i < datas.length; i++) {
            if (Main.ultimoDiaMesValido(datas[i]).getTime() != expectedRes[i].getTime()) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private static boolean test_stringParaDateEConverterDatas(String[] datas, Date[] expectedRes) {
        boolean flag = true;
        for (int i = 0; i < datas.length; i++) {
            if (Main.stringParaDateEConverterDatas(datas[i]).getTime() != expectedRes[i].getTime()) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private static boolean test_converterDatasEntreSi(String[] datas, String[] expectedRes) {
        boolean flag = true;
        for (int i = 0; i < datas.length; i++) {
            if (datas[i].equals(expectedRes[i])) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private static boolean test_existeNoArrayData(String[] testDatas, String[] datas, boolean[] expectedRes) {
        boolean flag = true;
        for (int i = 0; i < datas.length; i++) {
            if (Main.existeNoArrayData(datas, testDatas[i]) != expectedRes[i]) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void runTestes() {
        int testCount = 0;
        int okCount = 0;

        System.out.println("\nTestes:");
        System.out.println("- Matrizes");

        // Teste 1 - comparar matrizes
        double[][] matriz1 = { { 1, 3, 2 }, { 4, 5, 3 }, { 9, 3, 1 } };
        boolean test1 = test_compararMatrizes(matriz1);
        printTestResult("compararMatrizes", ++testCount, test1);
        if (test1)
            okCount++;

        // Teste - multiplicar matrizes
        double[][] matriz2 = { { 1, -3, 2 }, { 5, -1, 1 }, { 3, 0, 2 } };
        double[][] matriz1Mult2 = { { 22, -6, 9 }, { 38, -17, 19 }, { 27, -30, 23 } };
        boolean test2 = test_multiplicarMatrizes(matriz1, matriz2, matriz1Mult2);
        printTestResult("multiplicarMatrizes", ++testCount, test2);
        if (test2)
            okCount++;

        // Teste - subtrair matrizes
        double[][] test8_expectedRes = { { 0, 3, -2 }, { -5, 2, -1 }, { -3, 0, -1 } };
        boolean test8 = test_subtrairIdentidadeComMatriz(matriz2, test8_expectedRes);
        printTestResult("subtrairIdentidadeComMatriz", ++testCount, test8);
        if (test8)
            okCount++;

        // Teste - elevar matriz
        double[][] matrizTest4_expectedRes = { { 244, 252, 147 }, { 469, 461, 266 }, { 462, 399, 223 } };
        boolean test3 = test_elevarMatriz(matriz1, 3, matrizTest4_expectedRes);
        printTestResult("elevarMatriz", ++testCount, test3);
        if (test3)
            okCount++;

        // Teste - preencher diagonal matriz
        double[][] matrizTest6_expectedRes = { { 3, 0, 0 }, { 0, 3, 0 }, { 0, 0, 3 } };
        boolean test6 = test_preencherDiagonalMatriz(3, 3, matrizTest6_expectedRes);
        printTestResult("preencherDiagonalMatriz", ++testCount, test6);
        if (test6)
            okCount++;

        /* Teste - trocar posições matriz
        double[][] trocarPosicoesMatriz = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        double[][] posicoes_expectedRes = { { 1, 4, 7 }, { 2, 5, 8 }, { 3, 6, 9 } };
        boolean testTrocarPosicoes = test_trocarPosicoesMatriz(trocarPosicoesMatriz, posicoes_expectedRes);
        printTestResult("trocarPosicoesMatriz", ++testCount, testTrocarPosicoes);
        if (testTrocarPosicoes)
            okCount++; */

        // Teste - matriz inversa L
        double[][] testeMatrizInversas = { { 1, 4, 7 }, { 2, 5, 8 }, { 3, 6, 9 } };
        double[][] invL_expectedRes = { { 1, 0, 0 }, { -.4, .2, 0 },
                { -.06666666666666662, -.13333333333333336, .1111111111111111 } };
        boolean test4 = test_matrizInversaL(testeMatrizInversas, invL_expectedRes);
        printTestResult("matrizInversaL", ++testCount, test4);
        if (test4)
            okCount++;

        // Teste - matriz inversa U
        double[][] invU_expectedRes = { { 1, -.8, -0.06666666666666662 }, { 0, .2, -.17777777777777778 },
                { 0, 0, .1111111111111111 } };
        boolean test5 = test_matrizInversaU(testeMatrizInversas, invU_expectedRes);
        printTestResult("matrizInversaU", ++testCount, test5);
        if (test5)
            okCount++;

        // Teste - decomposição Crout
        double[][] croutL_expectedRes = { { 1, 0, 0 }, { 4, -3, 0 }, { 7, -30, 48 } };
        double[][] croutU_expectedRes = { { 1, 2, 3 }, { 0, .2, 2 }, { 0, 0, .1111111111111111 } };
        boolean testCrout = test_decomposicaoCrout(invL_expectedRes, invU_expectedRes, testeMatrizInversas,
                croutL_expectedRes, croutU_expectedRes);
        printTestResult("decomposicaoCrout", ++testCount, testCrout);
        if (testCrout)
            okCount++;

        System.out.println("- Main");

        // Teste - calcular número de semanas
        Calendar cal1 = Calendar.getInstance();
        cal1.set(2021, 3, 6, 0, 0, 0);
        Calendar cal2 = Calendar.getInstance();
        cal2.set(2021, 5, 27, 0, 0, 0);
        boolean test9 = test_calcularNumSemanas(cal1.getTime(), cal2.getTime(), 11);
        printTestResult("calcularNumSemanas", ++testCount, test9);
        if (test9)
            okCount++;

        // Teste - calcular dias entre intervalo
        String[] intervalo = { "2020-01-02", "2021-01-03" };
        boolean test10 = test_calcularDiasEntreInvervalo(intervalo, 368);
        printTestResult("calcularDiasEntreIntervalo", ++testCount, test10);
        if (test10)
            okCount++;

        // Teste - validar datas
        String[] datas = { "2020-01-02", "01-04-2020", "1-4-2020", "2020-04-051", "2020/01/04" };
        boolean[] test11_expectedRes = { true, true, false, false, false };
        boolean test11 = test_validarDatas(datas, test11_expectedRes);
        printTestResult("validararDatas", ++testCount, test11);
        if (test11)
            okCount++;

        // Teste - último dia mes valido
        cal1.set(2020, 1, 28, 0, 0, 0);
        cal1.set(Calendar.MILLISECOND, 0);
        cal2.set(2021, 4, 31, 0, 0, 0);
        cal2.set(Calendar.MILLISECOND, 0);
        Calendar expectedRes1 = Calendar.getInstance();
        expectedRes1.set(2020, 0, 31, 0, 0, 0);
        expectedRes1.set(Calendar.MILLISECOND, 0);
        Calendar expectedRes2 = Calendar.getInstance();
        expectedRes2.set(2021, 4, 31, 0, 0, 0);
        expectedRes2.set(Calendar.MILLISECOND, 0);

        Date[] test12_datas = { cal1.getTime(), cal2.getTime() };
        Date[] test12_expectedRes = { expectedRes1.getTime(), expectedRes2.getTime() };
        boolean test12 = test_ultimoDiaMesValido(test12_datas, test12_expectedRes);
        printTestResult("ultimoDiaMesValido", ++testCount, test12);
        if (test12)
            okCount++;

        // Teste - string para date e converter
        String[] testeConverterDatasStrings = { "2020-02-29", "01-12-2021" };
        Calendar testeConverterData1 = Calendar.getInstance();
        testeConverterData1.set(2020, 1, 29, 0, 0, 0);
        testeConverterData1.set(Calendar.MILLISECOND, 0);
        Calendar testeConverterData2 = Calendar.getInstance();
        testeConverterData2.set(2021, 11, 1, 0, 0, 0);
        testeConverterData2.set(Calendar.MILLISECOND, 0);

        boolean testConverterDatas = test_stringParaDateEConverterDatas(testeConverterDatasStrings,
                new Date[] { testeConverterData1.getTime(), testeConverterData2.getTime() });
        printTestResult("stringParaDateEConverterDatas", ++testCount, testConverterDatas);
        if (testConverterDatas)
            okCount++;

        // Teste - converter datas entre si
        String[] convEntreSi_expectedRes = { "29-02-2020", "2021-12-01" };
        boolean testConvEntreSi = test_converterDatasEntreSi(testeConverterDatasStrings, convEntreSi_expectedRes);
        printTestResult("converterDatasEntreSi", ++testCount, testConvEntreSi);
        if (testConvEntreSi)
            okCount++;

        // Teste - existe no array datas
        String[] testExisteDataStrings = { "2020-02-29", "2020-01-01" };
        boolean[] existeData_expectedRes = { true, false };
        boolean testExisteData = test_existeNoArrayData(testExisteDataStrings, testeConverterDatasStrings,
                existeData_expectedRes);
        printTestResult("existeNoArrayData", ++testCount, testExisteData);
        if (testExisteData)
            okCount++;

        System.out.printf("\n%s/%s testes efetuados com sucesso.\n", okCount, testCount);
    }

    private static void printTestResult(String testName, int testCount, boolean testRes) {
        System.out.printf("%5s %-30s %s\n", "[" + testCount + "]", testName, (testRes ? "OK" : "NOT OK"));
    }

    public static void printMatriz(double[][] matriz) {
        System.out.println();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.printf("%10s", matriz[i][j]);
                // System.out.printf("%10.6s", matriz[i][j]);
            }
            System.out.println();
        }
    }
}
