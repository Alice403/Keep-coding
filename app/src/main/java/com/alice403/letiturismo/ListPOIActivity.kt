package com.alice403.letiturismo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class ListPOIActivity : AppCompatActivity() {

    private lateinit var listSitiosTuristicos: ArrayList<SitiosTuristicosItem>
    private lateinit var sitiosTuristicosAdapter: SitiosTuristicosAdapter
    private lateinit var sitiosTuristicosRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_poiactivity)

        //Configuracion del RecyclerView
        sitiosTuristicosRecyclerView = findViewById(R.id.poi_recycler_view)

        //Creacion del Mock para Probar listas
       // listSitiosTuristicos = createMockSitiosTuristicos()
        listSitiosTuristicos = loadMockSitiosTuristicosAdapterFromJson()

        sitiosTuristicosAdapter = SitiosTuristicosAdapter(listSitiosTuristicos)



        sitiosTuristicosRecyclerView.apply{
            layoutManager = LinearLayoutManager(context)
            adapter = sitiosTuristicosAdapter
            setHasFixedSize(false)
        }
        //sitiosTuristicosRecyclerView.adapter = sitiosTuristicosAdapter
    }

    private fun loadMockSitiosTuristicosAdapterFromJson(): ArrayList<SitiosTuristicosItem> {
        var  sitiosTuristicosString: String = applicationContext.assets.open("poi.json").bufferedReader().use{it.readText()}
        val gson = Gson()
        val data = gson.fromJson(sitiosTuristicosString, SitiosTuristicos::class.java)
        return data
    }

   /* private fun SitiosTuristicosAdapterFromJson(): ArrayList<SitiosTuristicos> {

    } */


    /*  private fun createMockSitiosTuristicos(): ArrayList<SitiosTuristicos> {
         /* Crear Sitios Turisticos Uno a Uno
         var lista:ArrayList<SitiosTuristicos> = arrayListOf()
         var sitiosTuristicos = SitiosTuristicos (
         nombre = "Isla de los micos",
         puntuacion = 4.5F,
         descripcionCorta = "Es una isla habitada por micos en la cual los turistas pueden convivir con ellos y tomarse fotos",
         descripcion = "Su nombre se debe a la cantidad de micos que habitan el lugar y que se han convertido en gran atractivo para los turistas, quienes llegan allí a conocerlos, darles de comer y tomarse una atractiva foto.",
         datosAdicionales = "¿Cómo llegar? Debes viajar unos 45min en lancha, partiendo de Leticia. En este lugar vas a encontrar unas plataformas elevadas desde donde podrás observar a los micos, que son los habitantes de la zona.",
         horario = "8:00 am - 5:00 p.m",
         precio = "desde $30.000",
         ubicacion = "La isla esta a 20 kilómetros río arriba de la ciudad de Leticia, a la altura de la localidad de Santa Sofía.",
         temperatura = "27°"
         //UrlImagen= "https://res.cloudinary.com/alejandra403/image/upload/v1637356279/islaDe_LosMicos_liyb2q.jpg"

         )

         lista.add(sitiosTuristicos)
 */
         return arrayListOf(
             SitiosTuristicos(
                 nombre = "Isla de los micos",
                 puntuacion = "Puntuacion= "+ 4.5F,
                 descripcionCorta = "Es una isla habitada por micos en la cual los turistas pueden convivir con ellos y tomarse fotos",
                 descripcion = "Su nombre se debe a la cantidad de micos que habitan el lugar y que se han convertido en gran atractivo para los turistas, quienes llegan allí a conocerlos, darles de comer y tomarse una atractiva foto.",
                 datosAdicionales = "¿Cómo llegar? Debes viajar unos 45min en lancha, partiendo de Leticia. En este lugar vas a encontrar unas plataformas elevadas desde donde podrás observar a los micos, que son los habitantes de la zona.",
                 horario = "8:00 am - 5:00 p.m",
                 precio = "desde $30.000",
                 ubicacion = "La isla esta a 20 kilómetros río arriba de la ciudad de Leticia, a la altura de la localidad de Santa Sofía.",
                 temperatura = "27°",
                 UrlImagen= "https://res.cloudinary.com/alejandra403/image/upload/v1637356279/islaDe_LosMicos_liyb2q.jpg"

             ),
             SitiosTuristicos(
                 nombre = "Parque ecológico mundo amazónico",
                 puntuacion = "Puntuacion= "+ 4.6F,
                 descripcionCorta = "Es un espacio donde se pueden observar distintas especies de plantas del amazonas",
                 descripcion = "Su nombre se debe a la cantidad de micos que habitan el lugar y que se han convertido en gran atractivo para los turistas, quienes llegan allí a conocerlos, darles de comer y tomarse una atractiva foto.",
                 datosAdicionales = "¿Cómo llegar? Debes viajar unos 45min en lancha, partiendo de Leticia. En este lugar vas a encontrar unas plataformas elevadas desde donde podrás observar a los micos, que son los habitantes de la zona.",
                 horario = "8:00 am - 5:00 p.m",
                 precio = "desde $30.000",
                 ubicacion = "La isla esta a 20 kilómetros río arriba de la ciudad de Leticia, a la altura de la localidad de Santa Sofía.",
                 temperatura = "27°",
                 UrlImagen= "https://res.cloudinary.com/alejandra403/image/upload/v1637356279/parqueMundoAmazonico_u4aekg.jpg"
         )
         )
     }
     */

}