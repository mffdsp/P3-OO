# FolhaDePagamentoRefactored

## Projeto Refatoramento - Folha de Pagamento

Utilização inicial -> 
Igual ao do projeto OO, do diretório [FolhaDePagamentoOO](https://github.com/hglps/FolhaDePagamentoOO/) , 
no entanto, a entrada é por uma string descrevendo a funcionalidade desejada.

# Padrões de projeto utilizados

## Factory
| Implementação | Utilização|
| ------------- | ----------- | 
|  choicemenusfactory/ChoiceFactory.java    |  choicemenufactory/NewEmployee.java |
|   registerfactory/ChangeRegisterFactory.java |  main/Headmaster.java |
|   typemenufactory/TypeEmployeeFactory.java | registerfactory/TypeChange.java |
| | choicemenufactory/ChangeRegister.java |

---

## Visitor
| Interface | Implementação |  Utilização |
| ------------- | ------------- | ------------- |
|  visitor/(Visitor.java ; Visitable.java)    |  visitor/CalculateSalaryVisitor.java   |   main/Headmaster.java|
|     |  companypackage/(Hourly.java ; Commissioned.java ; Salaried.java)   |   

---

## Interpreter
| Interface | Implementação |  Utilização |
| ------------- | ------------- | ------------- |
|  interpreter/Specification.java    |  nterpreter/(NewSaleSpec.java ; NewServiceFeeSpec.java ; PartOfUnion.java)  |   choicemenufactory/NewSale.java |
|     |    |  registerfactory/UnionFeeChange.java |

---

## Strategy
| Interface | Implementação |  Utilização |
| ------------- | ------------- | ------------- |
| strategy/UnionContract.java     |  strategy/(UnionMember.java ; NotUnionMember.java)  |   companypackage/Employee.java |

---

## Command
| Interface | Implementação | 
| ------------- | ------------- | 
| choicemenusfactory/ChoiceOperation.java     |  choicemenusfactory/(CardUpdate.java ; ChangeRegister.java ; DeleteEmployee.java ; InvalidChoice.java ; NewEmployee.java ; NewSale.java ; Payroll.java ; ServiceFee.java ; ShowInfo.java ; )
  |   companypackage/Employee.java |
|  registerfactory/ChangeOperation.java     |  registerfactory/ (AddressChange.java ;  InvalidChange.java ; NameChange.java ; TypeChange.java ; UnionChange.java ; UnionFeeChange.java ; WayChange.java)  |
|  typemenufactory/TypeOperation.java      | typemenufactory/ (AddCommissioned.java ; AddHourly.java ; AddSalaried.java ; InvalidType.java ; ReturnCommissioned.java; ReturnHourly.java; ReturnSalaried.java)  | 


Info: **hlc2@ic.ufal.br**
         
              
               
               
               
               
               
               
               
               
               
               
               
                            "--------------------------------------------------------"
                            "------                   HELP                      -----"
                            "------                                             -----"
                            "------            Instruções de Uso:               -----"
                            "------                                             -----"
                            "------  + Executar = java -jar executavel.jar      -----"
                            "------  + Cada Btn representa uma função*          -----"  
                            "------  + Datas/Horas são fantasiosas              -----"
                            "------  + Undo/Redo válidos para toda ação         -----"
                            "------  + Code = 2019XX // Scode = 111XX           -----"
                            "------  + Senha/user inicial - "admin/admin"       -----"
                            "------  + Taxa inicial de comissão = 15%           -----"
                            "------  + Dúvidas - mffsp@ic.ufal.br               -----"
                            "------                                             -----"
                            "------                                             -----"
                            "------  *Obrigatório                               -----"
                            "--------------------------------------------------------"
      
      

OLDCOMMITS = https://github.com/mffdsp/P3/tree/master/Projeto-OO

## Funções implementadas

`Adição de um empregado -> OK`

`Remoção de um empregado -> OK`

<img src="src/tenor.gif" align= "right">

`Lançar um Cartão de Ponto -> OK`

`Lançar um Resultado Venda -> OK`

`Lançar uma taxa de serviço -> OK`

`Alterar detalhes de um empregado -> OK`

`Rodar a folha de pagamento para hoje -> OK`

`Undo/redo -> OK`

`Agenda de Pagamento -> OK`

`Criação de Novas Agendas de Pagamento -> OK`

# Instruções de entrada
 
```java
private static void addEmpregado(){

    insertName(String);
    insertAdress(String);
    insertType(int);
    insertMethod(int);
    insertSalary(double);
    insertBoolSindicaty(int);

}

private static void rmvEmpregado(){

    insertCode(String);

}

private static void launchCard(){

    insertCode(String);
    inserType(int);


}
private static void launchSellResult(){

    insertCode(String);
    insertValue(double);
    insertDay(int);
    
}
private static void launchSindicalTaxes(){

    insertSindicalCode(String);
    insertValue(double);
    
}
private static void editEmpregado(){

    insertCode(String);
    insertName(String);
    insertAdress(String);
    insertType(int);
    insertMethod(int);
    insertSalary(double);
    insertBoolSindicaty(int);

}
private static void payRoll(){

    confirmAction();

}
private static void UndoRedo(){

    confirmAction();
    
}
private static void searchEmpregado(){

    insertMode(int);
    insertSearch(String);
    insertRecover(String);

}

private static void createPayRoll(){

    insertName(String);
    insertType(int);
    insertDay(int);
    insertDayOfWeek(int);

}


```


.................

MIT License

Copyright (c) 2019 Mateus Felismino

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
