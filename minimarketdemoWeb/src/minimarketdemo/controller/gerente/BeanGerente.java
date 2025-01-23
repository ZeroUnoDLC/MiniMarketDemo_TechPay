package minimarketdemo.controller.gerente;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import minimarketdemoFact.entities.ResumenFacturasAnual;
import minimarketdemoFact.entities.ResumenFacturasMensual;
import minimarketdemoFact.entities.ResumenPedidosMensual;
import minimarketdemoFact.manager.ManagerMinimarketdemoFact;

import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

@Named
@SessionScoped
public class BeanGerente implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private ManagerMinimarketdemoFact mMiniMarketDemoFact;

    private List<ResumenFacturasAnual> listaResumenFacturasAnual;
    private List<ResumenFacturasMensual> listaResumenFacturasMensual;
    private List<ResumenPedidosMensual> listaResumenPedidos;

    // Para el gráfico de barras
    private BarChartModel graficoResumenFacturas;

    // Arreglo de los nombres de los meses
    private static final String[] NOMBRE_MESES = {
        "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", 
        "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
    };

    public BeanGerente() {
        // Constructor
    }

    // Método para convertir el número de mes a su nombre
    private String obtenerNombreMes(int numeroMes) {
        if (numeroMes >= 1 && numeroMes <= 12) {
            return NOMBRE_MESES[numeroMes - 1];
        }
        return "Mes Desconocido"; // En caso de que el mes no sea válido
    }

    // Métodos para cargar los datos
    public String actionCargarMenuResumenFacturasAnual() {
        listaResumenFacturasAnual = mMiniMarketDemoFact.findAllFacturasAnual();
        return "factura_anual";
    }

    public String actionCargarMenuResumenFacturasMensual() {
        listaResumenFacturasMensual = mMiniMarketDemoFact.findAllFacturasMensual();
        inicializarGraficoResumenFacturas(); // Llamar al método para inicializar el gráfico
        return "factura_mensual";
    }

    public String actionCargarMenuResumenPedidosMensual() {
        listaResumenPedidos= mMiniMarketDemoFact.findAllPedidosMensual();
        return "pedido_mensual";
    }
    
    //Mostrar cada tipo de pedidos
    public void mostrarTodosPedidos() {
    	listaResumenPedidos= mMiniMarketDemoFact.findAllPedidosMensual();
    }
    
    public void mostrarPedidosDespachados() {
    	listaResumenPedidos= mMiniMarketDemoFact.findAllPedidosMensualDespachados();
    }
    
    public void mostrarPedidosPendientes() {
    	listaResumenPedidos= mMiniMarketDemoFact.findAllPedidosMensualPendientes();
    }

    // Método para inicializar el gráfico de barras
    public void inicializarGraficoResumenFacturas() {
        graficoResumenFacturas = new BarChartModel();

        // Crear las series para las cantidades de facturas y los totales facturados
        ChartSeries cantidadFacturas = new ChartSeries();
        cantidadFacturas.setLabel("Cantidad de Facturas");

        ChartSeries totalFacturado = new ChartSeries();
        totalFacturado.setLabel("Total Facturado");

        // Llenar las series con los datos de las facturas mensuales
        for (ResumenFacturasMensual resumen : listaResumenFacturasMensual) {
            // Convertir el número de mes a su nombre
            String nombreMes = obtenerNombreMes(resumen.getMes().intValue()); 
            String mesAnio = nombreMes + " " + resumen.getAnio(); // Combinamos mes y año
            cantidadFacturas.set(mesAnio, resumen.getCantidadFacturas());
            totalFacturado.set(mesAnio, resumen.getSumaTotal());
        }

        // Agregar las series al gráfico
        graficoResumenFacturas.addSeries(cantidadFacturas);
        graficoResumenFacturas.addSeries(totalFacturado);
    }

    // Getters y Setters
    public List<ResumenFacturasAnual> getListaResumenFacturasAnual() {
        return listaResumenFacturasAnual;
    }

    public void setListaResumenFacturasAnual(List<ResumenFacturasAnual> listaResumenFacturasAnual) {
        this.listaResumenFacturasAnual = listaResumenFacturasAnual;
    }

    public List<ResumenFacturasMensual> getListaResumenFacturasMensual() {
        return listaResumenFacturasMensual;
    }

    public void setListaResumenFacturasMensual(List<ResumenFacturasMensual> listaResumenFacturasMensual) {
        this.listaResumenFacturasMensual = listaResumenFacturasMensual;
    }

    public BarChartModel getGraficoResumenFacturas() {
        return graficoResumenFacturas;
    }

    public void setGraficoResumenFacturas(BarChartModel graficoResumenFacturas) {
        this.graficoResumenFacturas = graficoResumenFacturas;
    }

	public List<ResumenPedidosMensual> getListaResumenPedidos() {
		return listaResumenPedidos;
	}

	public void setListaResumenPedidos(List<ResumenPedidosMensual> listaResumenPedidos) {
		this.listaResumenPedidos = listaResumenPedidos;
	}
    
    
}
