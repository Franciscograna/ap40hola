public abstract class Descuento {
private float valor;
  
public float getValorDesc() {
return valor;
}
public void setValorDesc(float valor) {
this.valor = valor;
}
public abstract float valorFinal(float valorInicial);
}
//

public class DescuentoFijo extends Descuento {
@Override
public float valorFinal(float valorInicial) {
return valorInicial - this.getValorDesc();
  }
}

//

public class DescuentoPorcentaje extends Descuento {
@Override
public float valorFinal(float valorInicial) {
return valorInicial - (valorInicial *this.getValorDesc());
    }
}
