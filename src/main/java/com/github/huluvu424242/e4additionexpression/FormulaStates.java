package com.github.huluvu424242.e4additionexpression;

public interface FormulaStates {

    FormulaContext build();

    public interface Zahl1 extends FormulaStates {

        default FormulaStates.Zahl1 digit(int digit) {
            if (digit < 0 || digit > 9) {
                throw new IllegalArgumentException("wrong digit:" + digit);
            }
            final FormulaContext context = build();
            // append digit to current number
            context.zahlBuilder().append(digit);
            return this;
        }

        default FormulaStates.Plus plus() {
            final FormulaContext context = build();
            final int zahl = Integer.parseInt(context.zahlBuilder().toString());
            FormulaContext contextNeu = new FormulaContext(zahl, new StringBuilder());
            return () -> contextNeu;
        }
    }

    public interface Plus extends FormulaStates {
        default FormulaStates.Zahl digit(int digit) {
            if (digit < 0 || digit > 9) {
                throw new IllegalArgumentException("wrong digit:" + digit);
            }
            final FormulaContext context = build();
            // append digit to current number
            context.zahlBuilder().append(digit);
            return this::build;
        }
    }

    public interface Zahl extends FormulaStates {

        default FormulaStates.Zahl digit(int digit) {
            if (digit < 0 || digit > 9) {
                throw new IllegalArgumentException("wrong digit:" + digit);
            }
            final FormulaContext context = build();
            // append digit to current number
            context.zahlBuilder().append(digit);
            return this;
        }

        default FormulaStates.Plus plus() {
            final FormulaContext context = build();
            final int zahl = Integer.parseInt(context.zahlBuilder().toString());
            FormulaContext contextNeu = new FormulaContext(context.summe() + zahl, new StringBuilder());
            return () -> contextNeu;
        }

        default FormulaStates.Final equals() {
            final FormulaContext context = build();
            final int zahl = Integer.parseInt(context.zahlBuilder().toString());
            FormulaContext contextNeu = new FormulaContext(context.summe() + zahl, new StringBuilder());
            return () -> contextNeu;
        }
    }

    interface Final extends FormulaStates {

    }
}
