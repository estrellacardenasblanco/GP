package cu.edu.cujae.backend.core.dto;


import java.sql.Date;


/*import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfInt;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;*/

@SuppressWarnings("serial")
public class PictureDto {

	private String url;
	private int id;	
	private String name; 
	private Date date;
	private String quality;
	 
	 public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public PictureDto(String url, int id, String name, Date date, String quality) {
		super();
		this.url = url;
		this.id = id;
		this.name = name;
		this.date = date;
		this.quality = quality;
	}
	public PictureDto() {
		
	}


	public void calculateQuality() {
		// es un arreglo que las pos coiciden con el color de 0 a 255 
		 // entonces en cada pos esta un arreglo donde en la pos 0 esta la frecuencia
		 
		 /*URL img= getClass().getResource(url);
		 String ruta = img.getPath();
		 if (ruta.startsWith("/")){
			 ruta=ruta.substring(1);
		 }*/
		 
		 // images: imagen de matriz de origen 
		 // channels: lista de los canales 
		 // mask mascara: los elementos distintos de cero marcan los elementos de la matriz contados en el hist
		 // hist: histograma de salida 
		 // histSize matriz de los tamanos en cada dimension
		 // ranges: matriz de las matrices de dims de los limites del contenedor de hist en cada dimension
		 
		 /*Mat mat= Imgcodecs.imread("E:/Base de Datos/bin"+url, Imgcodecs.IMREAD_GRAYSCALE);  //imagen de estrada, puede ser a escala de grises o colores. 
		 
		 ArrayList<Mat> listOfMat= new ArrayList<Mat>();
		 listOfMat.add(mat);
		 MatOfInt channels = new MatOfInt(0); //�ndice de canal para el cual deseamos calcular el histograma, en una imagen a escala de grises [0], si la imagen es a colores podemos indicar [0], [1], [2] para los canales B, G, R respectivamente.
		 Mat mask = new Mat();  //mascara que define la regi�n sobre la que deseamos calcular el histograma, es opcional. 
		 Mat hist = new Mat(256,1,CvType.CV_8UC1);
		 MatOfInt histSize = new MatOfInt(256); // tiene 256 contenedores es la intensidad max
		 MatOfFloat ranges = new MatOfFloat(0,256); //nuestro rango de valores, usaremos [0, 256]. 
		 Imgproc.calcHist(listOfMat, channels, mask, hist, histSize, ranges);

		 int posQ1 = hist.rows()*25/100;
		 int posQ2 = hist.rows()*50/100;
		 int posQ3 = hist.rows()*75/100;
		 
		 // posQ1 es la fila , 0 xq es 1 columna y en la pos 0 esta la frecuencia
		 double Q1= (hist.get(posQ1,0)[0]+hist.get(posQ1+1,0)[0])/2;
		 double Q2= (hist.get(posQ2,0)[0]+hist.get(posQ2+1,0)[0])/2;
		 double Q3= (hist.get(posQ3,0)[0]+hist.get(posQ3+1,0)[0])/2;
		 
		 double DIq1 = Q2- Q1;
		 double DIq2 = Q3-Q2;
		 
		 double Cal;
		 
		 if(DIq2 > 0)
			 Cal = 1 - DIq1 / DIq2;
		 else
			 Cal = 0;
		 
		 if(Cal > 0.6) {
			 calidad = "baja";
		 }
		 else if(Cal > 0.3 && Cal<=0.6) {
			 calidad = "media";
		 }
		 else if(Cal <= 0.3) {
			 calidad = "alta";
		 }
		 */
	}
	
}
