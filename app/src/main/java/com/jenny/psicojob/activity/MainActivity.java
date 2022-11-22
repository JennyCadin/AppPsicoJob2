package com.jenny.psicojob.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import com.jenny.psicojob.R;
import com.jenny.psicojob.adaptador.RecyclerAdapter;
import com.jenny.psicojob.model.ItemList;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.RecyclerItemClick, SearchView.OnQueryTextListener {
    private RecyclerView rvLista;
    private SearchView svSearch;
    private RecyclerAdapter adapter;
    private List<ItemList> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initValues();
        initListener();


        Button btnInsertar = findViewById(R.id.button4);
        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Cuestionariouno.class);
                startActivity(intent);
            }
        });

    }



    private void initViews(){
        rvLista = findViewById(R.id.rvLista);
        svSearch = findViewById(R.id.svSearch);
    }

    private void initValues() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvLista.setLayoutManager(manager);

        items = getItems();
        adapter = new RecyclerAdapter(items, this);
        rvLista.setAdapter(adapter);
    }

    private void initListener() {
        svSearch.setOnQueryTextListener(this);
    }

    private List<ItemList> getItems() {
        List<ItemList> listaMenu = new ArrayList<>();

        ItemList detalleTemas = new ItemList("Arma tu curriculum",getString(R.string.descripcion_temas), getString(R.string.descripcion_larga), R.drawable.cv);
        listaMenu.add(detalleTemas);

        listaMenu.add(new ItemList("¿Qué es una entrevista psicolaboral?", "Las evaluaciones psicolaborales son un conjunto de técnicas que se utilizan para conocer rasgos de la persona que no se determinan en una entrevista o leyendo su curriculum vitae. Sirven para determinar si el candidato es psicológicamente, lo suficientemente apto para el puesto al que se postula.","Las distintas entrevistas laborales se componen de 3 grandes bloques: el inicio de la entrevista, en el que será clave la primera impresión; el desarrollo de la entrevista, compuesto por las preguntas del entrevistador y las consultas del candidato; y, por último, el cierre de la entrevista.\n" +
                "\n" +
                "Como primer consejo, durante todo el proceso el candidato deberá demostrar una actitud positiva, entusiasmo e interés en lo que se está conversando, ya que el objetivo es  causar la mejor impresión en cada una de estas etapas.", R.drawable.queesentrev));

        listaMenu.add(new ItemList("Tips para rendir una buena entrevista", "Hay técnicas que te permiten dar una mejor entrevista. Acá te contamos:","la entrevista laboral es parte del proceso cuando buscas empleo, y hay dos tips fundamentales para dominarla:\n" +
                "\n" +
                "Prepararte\n" +
                "Practicar\n" +

                "Miguel Ángel Rangel, Gerente de Reclutamiento y Selección de Deloitte México, recomienda a los candidatos repasar la información colocada en el currículum y no poner información falsa, ya que más adelante el reclutador lo notará.\n" +
                "\n" +
                "Practiquen mucho, vayan a muchas entrevistas. A veces hay que juntar dos o tres ‘No’ para conseguir un ‘Sí’. Se darán cuenta de que muchas preguntas se repiten y podrán contestar mejor” comentó durante su participación en Expo City OCC 2016.", R.drawable.entrevista));
        listaMenu.add(new ItemList("¿Qué es Linkedin?", "LinkedIn es un integrador de redes profesionales de manera que, cuando invitas a conectar a alguien que conoces y dicha invitación es aceptada, de forma automática, tienes acceso a los contactos de dicho profesional.","Cómo funciona LinkedIn.\n" +
                "A continuación te vamos a mostrar cómo funciona cada uno de los recursos con los que cuenta LinkedIn, para que puedas sacar provecho a las funcionalidades de esta red social.\n" +
                "\n" +
                "Perfil\n" +
                "El perfil de LinkedIn, al igual que otras redes sociales, está compuesto por la información personal de los usuarios, tales como nombre, ciudad donde vive, edad y foto. El diferencial de esta plataforma es que tu currículum es el protagonista del perfil.\n" +
                "\n" +
                "En esta sección, tienes que detallar cuáles fueron tus trabajos anteriores, así como los cursos que realizaste, tus habilidades y competencias, entre otros aspectos profesionales.\n" +
                "\n" +
                "Otro elemento clave en este punto son las recomendaciones que tus colegas y líderes (actuales y anteriores) escriben sobre tí, ya que aumentan la relevancia de tu perfil profesional.\n" +
                "\n" +
                "En cuanto al perfil de un emprendimiento, es esencial mostrar cuáles son las acciones que la empresa está promoviendo: desde lanzamientos de productos hasta promociones o novedades generales. Esta es una excelente oportunidad para atraer potenciales clientes.", R.drawable.linkedin));
        listaMenu.add(new ItemList("¿Qué es una entrevista por competencia? ", "Básicamente, es una entrevista con preguntas sobre conducta en la cual el entrevistador te pedirá describir una situación que demuestre tus capacidades, las cuales serán fundamentales para el cargo al que aspiras.","El equipo de Robert Walters te ofrece a continuación cinco consejos que te ayudarán a conseguir el puesto de trabajo que deseas:\n" +
                "1. Prepárate\n" +
                "Como en cualquier otra modalidad de entrevista, la preparación es clave. Analiza la descripción del puesto para el que vas a ser entrevistado/a (habilidades o conocimientos requeridos) y busca similitudes entre la posición ofrecida y tu carrera profesional. Ya sea respecto a objetivos, logros o incluso en relación a empleados de la compañía con los cuales hayas podido trabajar con anterioridad.\n" +
                "“El entrevistador quiere que aportes ejemplos concretos de tu experiencia profesional, y que relaciones las destrezas adquiridas con el puesto vacante” explica Marco Laveda, CEO de Robert Walters Iberoamerica.\n" +
                "“Tómate tu tiempo para recordar de qué forma has sobresalido durante tu trayectoria profesional e identifica aquellas ocasiones en las que has demostrado contar con las competencias necesarias para la posición”, puntualiza Laveda.\n" +
                "2. Practica tus respuestas\n" +
                "Practica tus respuestas para poder exponer tus logros de manera convincente cuando llegue el momento de la entrevista. Deberás expresarlas con fluidez, detalle y una estructura lógica. Todo ejemplo, proceso, problema u objetivo que expongas jugará a tu favor y proporcionará solidez a tu discurso. Además, existen ciertas habilidades profesionales (gestión de equipos, gestión del tiempo, capacidad multitarea) muy demandadas en la actualidad. Ser capaz de buscar el momento idóneo para demostrar estas aptitudes, te dará una ventaja competitiva con respecto al resto de candidatos.\n" +
                "3. Presta atención a tu entrevistador\n" +
                "Aprende a interpretar las señales enviadas por tu entrevistador. Atender a su lenguaje verbal o a sus preguntas más reiteradas te ayudará a saber qué tipo de ejemplos le interesa que expongas. El candidato más preparado adaptará su discurso a lo que la empresa busca, demostrará su capacidad de influencia. En este sentido, será clave identificar el nivel de formalidad requerido por el entrevistador para conseguir que la conversación sea dinámica y fluida.\n" +
                "4. Anticípate a las preguntas\n" +
                "Acertarás con tus respuestas si te haces una idea previa de las preguntas que se te van a realizar. Existen tres preguntas recurrentes en una entrevista por competencias:\n" +
                "•\tDescribe cómo gestionaste un proyecto con un plazo de entrega muy ajustado a la vez que tenías que gestionar tu carga de trabajo habitual.\n" +
                "•\tAporta un ejemplo de una tarea compleja que hayas tenido que realizar y explica cómo la ejecutaste.\n" +
                "•\t¿Has tenido que trabajar en diferentes proyectos simultáneamente? ¿Cómo organizaste tu agenda para cumplir con tus funciones de manera efectiva?\n" +
                "5. Sé tú mismo\n" +
                "“Una parte vital de la entrevista por competencias consiste en promocionar tus habilidades, pero no te interesa encontrar un trabajo a base de mentiras o medias verdades. Los profesionales de selección saben cuándo un candidato está intentando encajar en el rol de manera forzada, o contestar de manera correcta en lugar de una manera genuina\", continúa Marco Laveda.\n" +
                "Permite al entrevistador conocerte, comparte con él tus experiencias y propias habilidades. Las empresas no quieren respuestas modelo, desean recibir información veraz y convincente, y expresada de forma correcta.\n", R.drawable.competenciaentre));
        listaMenu.add(new ItemList("¿Cómo manejar la ansiedad y nerviosismo?", "Si buscas formas de cómo relajarse antes de una entrevista, meditar es la mejor técnica. La respiración consciente y profunda te ayudará a deshacerte de ese flujo de pensamientos negativos que te hacen dudar de ti mismo, calmar la ansiedad y tranquilizar tu mente. Hazlo media hora antes de entrar a la entrevista.","Te damos 10 consejos para calmar tu ansiedad por la segunda entrevista: \n" +
                "\n" +
                "1. Analiza tu desempeño en la primera entrevista.\n" +
                "\n" +
                "2. Identifica la información que no hayas abarcado.\n" +
                "\n" +
                "3. Investiga más: ponte en contacto con un colaborador y tengan una charla informal.\n" +
                "\n" +
                "4. Lee publicaciones especializadas para que estés al día sobre los avances.\n" +
                "\n" +
                "5. Averigua cómo será la entrevista: ¿personalizada, en grupos o en un centro de evaluación?\n" +
                "\n" +
                "6. Espera lo mismo que en la primera entrevista, pero actualiza tus respuestas.\n" +
                "\n" +
                "7. Prepárate para las preguntas sobre competencias, un clásico de las segundas entrevistas.\n" +
                "\n" +
                "8. Haz preguntas al final de cada etapa.\n" +
                "\n" +
                "9. Ensaya un discurso sobre tu sueldo, beneficios y traslado.\n" +
                "\n" +
                "10. Si no te hacen una oferta, pregunta sobre la próxima etapa del proceso.", R.drawable.ansiedad));
        listaMenu.add(new ItemList("Tips para afrontar entrevista online", "La entrevista on line de igual forma merece ciertos resguardos y cuidados a considerar: .", "Cuida tu foto de perfil y tu nombre de usuario en el programa que utilices para hacer la videoconferencia para mostrar profesionalidad.\n" +
                "Asegúrate de tener conexión a internet y de la calidad de la misma. Evitarás momentos incómodos como cortes en el vídeo o en el sonido con el entrevistador.\n" +
                "Vigila la iluminación y el sonido ambiente. Evita espacios oscuros y donde haya mucho ruido para que la calidad del vídeo y del sonido sean óptimos.\n" +
                "Elige un buen lugar para hacer la entrevista. Intenta estar solo en el lugar que elijas para realizar la entrevista y así evitar distracciones. Es muy importante elegir un espacio ordenado y limpio ya que muchas veces no nos damos cuenta de que, según donde esté situado el ordenador, el fondo de la habitación también se ve.\n" +
                "No te olvides de cuidar la imagen. Vístete como si de una entrevista personal se tratase, porque aunque la entrevista sea a través de una pantalla, una imagen vale más que mil palabras.\n" +
                "Haz pruebas previas a la entrevista. Asegúrate de que el programa que utilices esté actualizado a la última versión y que funciona correctamente. Realiza una videollamada de prueba para comprobar que la conexión a internet es la esperada.\n" +
                "Sé puntual, incluso en una cita virtual. Intenta conectarte unos minutos antes y espera de forma paciente y con calma la llamada de tu entrevistador.\n" +
                "Mantener la postura y el tono de voz durante toda la entrevista, mostrará seguridad.\n" +
                "Mirar directamente a la cámara es como si miraras a los ojos a tu entrevistador. Así mostrarás que estás totalmente centrado en la entrevista.\n" +
                "Deja que tu entrevistador sea quien finalice la llamada, así evitarás cortar la conversación y que a tu entrevistador le queden cosas por decirte.", R.drawable.entrevonline));
        listaMenu.add(new ItemList("Tips para negociar sueldo", "Cuando preguntan por tus pretensiones de sueldo, debes considerar lo siguiente:.","Una de las preguntas más típicas y comunes en las entrevistas de trabajo (sea con headhunter o directamente con la compañía) sobre el salario. Pero que sin la preparación previa, puede ser incomoda e inclusive decisiva a la hora de avanzar en el proceso.\n" +
                "\n" +
                "Son varios los temas que se tratan en una entrevista de trabajo, donde el entrevistador busca conocer en profundidad a los candidatos, desde sus temas personales a logros profesionales, responsabilidades, y hasta temas de competencias y liderazgo, para luego contrarrestar con lo relacionado a expectativas futuras de crecimiento ligado a la pretensión salarial.\n" +
                "\n" +
                "Para prepararse a lo anterior, clave es informarse en profundidad de la actividad de la empresa, mercados en los que operan, número de empleados, conocer sus valores corporativos y también revisar vínculos o nexos con alguien que haya estado ligado a la compañía.\n" +
                "\n" +
                "¿Qué debo responder cuando aparece en la mesa la expectativas salariales? La respuesta correcta es demostrar que independiente del salario a ofrecer, estas interesado por el proyecto, en especial en aquellos casos en los que estamos intentando acceder al mercado laboral por primera vez o relocalizarnos luego de un tiempo reinsertándose.\n" +
                "\n" +
                "Pero siempre hay ser claro, tanto la consultora o cliente con los candidatos, como el candidato hacia la oferta, y tenemos hablar directamente del salario que se espera recibir por las responsabilidades descritas en la posición, y es acá donde hay que mostrar ciertas habilidades de situación y control.\n" +
                "\n" +
                "Para negociar, las personas dentro del proceso de selección debe demostrar que son los profesionales que la empresa está buscando, y que su incorporación al equipo humano significará un valor añadido para la organización, tanto en la operación diaria y como candidato integro, preocupado del talento, de entregar conocimiento y avalar las competencias de liderazgo que están buscando. En relación a esto, los logros profesionales adquiridos en experiencias pasadas y actuales, son críticos.\n" +
                "\n" +
                "Si lo ofrecido por la compañía está por debajo de lo esperado, se recomienda evitar rechazar de entrada y poner todos los esfuerzos, de manera respetuosa, clara y con hechos, en lograr aumentarla.\n" +
                "\n" +
                "Además también se deben tratar aspectos no económicos de manera muy clara para poder sopesar, incluir en el paquete anual, y ver si es que equilibran. Entre ellos encontramos la flexibilidad horaria, las posibilidades de desarrollo, capacitaciones, viajes de negocio, bonos, movilización, seguros, entre otros. De hecho, este factor no monetario ha adquirido cada vez más importancia sobre todo en las nuevas generaciones, debido a que se valoran de manera poderosa otras cosas, relacionadas a la calidad de vida, desarrollo profesional y crecimiento.\n" +
                "\n" +
                "¿Cuál es el momento adecuado de tratar este tema?... Para la etapa final, siempre y cuando se haya conversado con el headhunter o consultor, quien entregará coach de como liderar este tema, desde dejar en claro si hay capacidad de negociación o de qué manera realizarlo. Si es directamente con la compañía, la negociación se debe hacer una vez el candidato se encuentra en la etapa final del proceso, ya que ya se han puesto sobre la mesa sus competencias, cualidades y existirá una ventana de negociación frente a lo pretendido.\n" +
                "\n" +
                "No rechazar sin evaluar la primera propuesta, si no cumple con las expectativas, pero el desafío interesa, se deberán colocar en tema los aspectos no económicos, y las posibilidades de reajuste siempre con resultados medibles en el corto – mediano plazo. Para poder evaluar la propuesta, es clave averiguar cuál es la banda salarial del mercado por un puesto similar, en ese determinado sector, y según la experiencia del candidato. Demostrar interés y motivación por el puesto ayudará a sensibilizar la negociación.\n" +
                "\n" +
                "En el caso de llegar a acuerdo, mostrar total disponibilidad, ganas de ser parte de la organización y lograr confianza con el futuro empleador. En el caso de no ser así, agradecer la oportunidad y dejar la mejor impresión con la compañía, además de realizar una evaluación del proceso de selección y reflexionar en conjunto con el headhunter donde pueden haber oportunidades de mejora.", R.drawable.sueldo));
        listaMenu.add(new ItemList("¿Qué debo cuidar antes de firmar un contrato?", "XXXXXXXXXXXXXXXXX.","xsxsxsx", R.drawable.contrato));
        listaMenu.add(new ItemList("¿Sirve aprender los test psicológicos?", "XXXXXXXX.","xsxsxsx", R.drawable.psicologico));
        listaMenu.add(new ItemList("Listado plataformas para postular a empleo", "En este apartado, te mostramos un listado de plataformas para postular a empleos, las más utilizadas.","Laborum.com, Trabajando.com, Computrabajo, GetonBoard, EmpleosPublicos, BNE, AiraVirtual.", R.drawable.plataformas));


        return listaMenu;
    }

    @Override
    public void itemClick(ItemList item) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("itemDetail", item);
        startActivity(intent);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.filter(newText);
        return false;

        }




    }

