package com.github.huluvu424242.e4additionexpression;

import com.github.huluvu424242.e3plantumldiagram.BuilderStates;
import com.github.huluvu424242.e3plantumldiagram.PlantumlEntityDiagramBuilder;

public abstract class AdditionFormulaBuilder implements FormulaStates.Zahl1{

    FormulaContext formulaContext;

    private AdditionFormulaBuilder(){
        this.formulaContext =new FormulaContext(0, new StringBuilder());
    }

    public static FormulaStates.Zahl1 builder() {
        final AdditionFormulaBuilder builder = new AdditionFormulaBuilder() {
            // will be never called, because is internal overridden by lambda in return of builder() method
            public FormulaContext build() {
                throw new UnsupportedOperationException("Call of method forbidden");
            }
        };
        // create new interface instance
        return () -> builder.formulaContext;
    }

}
