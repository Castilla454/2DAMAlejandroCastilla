public class Submarino {

    public static int profundidad = 0;
    public static int distancia = 0;
    public static int total;

    public static int calcularTotal(String[] conjuntoMovimientos) {
        for (int i = 0; i < conjuntoMovimientos.length; i++) {
            for (String movimiento : conjuntoMovimientos) {
                String[] partes = movimiento.split(" ");

                String direccion = partes[0];  // Primera parte es la dirección
                int valor = Integer.parseInt(partes[1]);  // Segunda parte es el valor

                switch (direccion.toLowerCase()) {
                    case "forward":
                        distancia += valor;
                        break;
                    case "up":
                        profundidad -= valor;
                        break;
                    case "down":
                        profundidad += valor;
                        break;
                }
            }
            total = distancia * profundidad;


        }
        return total;
    }
}
