package com.jenny.appsicojob.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jenny.appsicojob.R;
import com.jenny.appsicojob.adaptador.RecyclerAdapter;
import com.jenny.appsicojob.model.ItemList;

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

        listaMenu.add(new ItemList("??Qu?? es una entrevista psicolaboral?", "Las evaluaciones psicolaborales son un conjunto de t??cnicas que se utilizan para conocer rasgos de la persona que no se determinan en una entrevista o leyendo su curriculum vitae. Sirven para determinar si el candidato es psicol??gicamente, lo suficientemente apto para el puesto al que se postula.","Las distintas entrevistas laborales se componen de 3 grandes bloques: el inicio de la entrevista, en el que ser?? clave la primera impresi??n; el desarrollo de la entrevista, compuesto por las preguntas del entrevistador y las consultas del candidato; y, por ??ltimo, el cierre de la entrevista.\n" +
                "\n" +
                "Como primer consejo, durante todo el proceso el candidato deber?? demostrar una actitud positiva, entusiasmo e inter??s en lo que se est?? conversando, ya que el objetivo es  causar la mejor impresi??n en cada una de estas etapas.", R.drawable.queesentrev));

        listaMenu.add(new ItemList("Tips para rendir una buena entrevista", "Hay t??cnicas que te permiten dar una mejor entrevista. Ac?? te contamos:","la entrevista laboral es parte del proceso cuando buscas empleo, y hay dos tips fundamentales para dominarla:\n" +
                "\n" +
                "Prepararte\n" +
                "Practicar\n" +

                "Miguel ??ngel Rangel, Gerente de Reclutamiento y Selecci??n de Deloitte M??xico, recomienda a los candidatos repasar la informaci??n colocada en el curr??culum y no poner informaci??n falsa, ya que m??s adelante el reclutador lo notar??.\n" +
                "\n" +
                "Practiquen mucho, vayan a muchas entrevistas. A veces hay que juntar dos o tres ???No??? para conseguir un ???S?????. Se dar??n cuenta de que muchas preguntas se repiten y podr??n contestar mejor??? coment?? durante su participaci??n en Expo City OCC 2016.", R.drawable.entrevista));
        listaMenu.add(new ItemList("??Qu?? es Linkedin?", "LinkedIn es un integrador de redes profesionales de manera que, cuando invitas a conectar a alguien que conoces y dicha invitaci??n es aceptada, de forma autom??tica, tienes acceso a los contactos de dicho profesional.","C??mo funciona LinkedIn.\n" +
                "A continuaci??n te vamos a mostrar c??mo funciona cada uno de los recursos con los que cuenta LinkedIn, para que puedas sacar provecho a las funcionalidades de esta red social.\n" +
                "\n" +
                "Perfil\n" +
                "El perfil de LinkedIn, al igual que otras redes sociales, est?? compuesto por la informaci??n personal de los usuarios, tales como nombre, ciudad donde vive, edad y foto. El diferencial de esta plataforma es que tu curr??culum es el protagonista del perfil.\n" +
                "\n" +
                "En esta secci??n, tienes que detallar cu??les fueron tus trabajos anteriores, as?? como los cursos que realizaste, tus habilidades y competencias, entre otros aspectos profesionales.\n" +
                "\n" +
                "Otro elemento clave en este punto son las recomendaciones que tus colegas y l??deres (actuales y anteriores) escriben sobre t??, ya que aumentan la relevancia de tu perfil profesional.\n" +
                "\n" +
                "En cuanto al perfil de un emprendimiento, es esencial mostrar cu??les son las acciones que la empresa est?? promoviendo: desde lanzamientos de productos hasta promociones o novedades generales. Esta es una excelente oportunidad para atraer potenciales clientes.", R.drawable.linkedin));
        listaMenu.add(new ItemList("??Qu?? es una entrevista por competencia? ", "B??sicamente, es una entrevista con preguntas sobre conducta en la cual el entrevistador te pedir?? describir una situaci??n que demuestre tus capacidades, las cuales ser??n fundamentales para el cargo al que aspiras.","El equipo de Robert Walters te ofrece a continuaci??n cinco consejos que te ayudar??n a conseguir el puesto de trabajo que deseas:\n" +
                "1. Prep??rate\n" +
                "Como en cualquier otra modalidad de entrevista, la preparaci??n es clave. Analiza la descripci??n del puesto para el que vas a ser entrevistado/a (habilidades o conocimientos requeridos) y busca similitudes entre la posici??n ofrecida y tu carrera profesional. Ya sea respecto a objetivos, logros o incluso en relaci??n a empleados de la compa????a con los cuales hayas podido trabajar con anterioridad.\n" +
                "???El entrevistador quiere que aportes ejemplos concretos de tu experiencia profesional, y que relaciones las destrezas adquiridas con el puesto vacante??? explica Marco Laveda, CEO de Robert Walters Iberoamerica.\n" +
                "???T??mate tu tiempo para recordar de qu?? forma has sobresalido durante tu trayectoria profesional e identifica aquellas ocasiones en las que has demostrado contar con las competencias necesarias para la posici??n???, puntualiza Laveda.\n" +
                "2. Practica tus respuestas\n" +
                "Practica tus respuestas para poder exponer tus logros de manera convincente cuando llegue el momento de la entrevista. Deber??s expresarlas con fluidez, detalle y una estructura l??gica. Todo ejemplo, proceso, problema u objetivo que expongas jugar?? a tu favor y proporcionar?? solidez a tu discurso. Adem??s, existen ciertas habilidades profesionales (gesti??n de equipos, gesti??n del tiempo, capacidad multitarea) muy demandadas en la actualidad. Ser capaz de buscar el momento id??neo para demostrar estas aptitudes, te dar?? una ventaja competitiva con respecto al resto de candidatos.\n" +
                "3. Presta atenci??n a tu entrevistador\n" +
                "Aprende a interpretar las se??ales enviadas por tu entrevistador. Atender a su lenguaje verbal o a sus preguntas m??s reiteradas te ayudar?? a saber qu?? tipo de ejemplos le interesa que expongas. El candidato m??s preparado adaptar?? su discurso a lo que la empresa busca, demostrar?? su capacidad de influencia. En este sentido, ser?? clave identificar el nivel de formalidad requerido por el entrevistador para conseguir que la conversaci??n sea din??mica y fluida.\n" +
                "4. Antic??pate a las preguntas\n" +
                "Acertar??s con tus respuestas si te haces una idea previa de las preguntas que se te van a realizar. Existen tres preguntas recurrentes en una entrevista por competencias:\n" +
                "???\tDescribe c??mo gestionaste un proyecto con un plazo de entrega muy ajustado a la vez que ten??as que gestionar tu carga de trabajo habitual.\n" +
                "???\tAporta un ejemplo de una tarea compleja que hayas tenido que realizar y explica c??mo la ejecutaste.\n" +
                "???\t??Has tenido que trabajar en diferentes proyectos simult??neamente? ??C??mo organizaste tu agenda para cumplir con tus funciones de manera efectiva?\n" +
                "5. S?? t?? mismo\n" +
                "???Una parte vital de la entrevista por competencias consiste en promocionar tus habilidades, pero no te interesa encontrar un trabajo a base de mentiras o medias verdades. Los profesionales de selecci??n saben cu??ndo un candidato est?? intentando encajar en el rol de manera forzada, o contestar de manera correcta en lugar de una manera genuina\", contin??a Marco Laveda.\n" +
                "Permite al entrevistador conocerte, comparte con ??l tus experiencias y propias habilidades. Las empresas no quieren respuestas modelo, desean recibir informaci??n veraz y convincente, y expresada de forma correcta.\n", R.drawable.competenciaentre));
        listaMenu.add(new ItemList("??C??mo manejar la ansiedad y nerviosismo?", "Si buscas formas de c??mo relajarse antes de una entrevista, meditar es la mejor t??cnica. La respiraci??n consciente y profunda te ayudar?? a deshacerte de ese flujo de pensamientos negativos que te hacen dudar de ti mismo, calmar la ansiedad y tranquilizar tu mente. Hazlo media hora antes de entrar a la entrevista.","Te damos 10 consejos para calmar tu ansiedad por la segunda entrevista: \n" +
                "\n" +
                "1. Analiza tu desempe??o en la primera entrevista.\n" +
                "\n" +
                "2. Identifica la informaci??n que no hayas abarcado.\n" +
                "\n" +
                "3. Investiga m??s: ponte en contacto con un colaborador y tengan una charla informal.\n" +
                "\n" +
                "4. Lee publicaciones especializadas para que est??s al d??a sobre los avances.\n" +
                "\n" +
                "5. Averigua c??mo ser?? la entrevista: ??personalizada, en grupos o en un centro de evaluaci??n?\n" +
                "\n" +
                "6. Espera lo mismo que en la primera entrevista, pero actualiza tus respuestas.\n" +
                "\n" +
                "7. Prep??rate para las preguntas sobre competencias, un cl??sico de las segundas entrevistas.\n" +
                "\n" +
                "8. Haz preguntas al final de cada etapa.\n" +
                "\n" +
                "9. Ensaya un discurso sobre tu sueldo, beneficios y traslado.\n" +
                "\n" +
                "10. Si no te hacen una oferta, pregunta sobre la pr??xima etapa del proceso.", R.drawable.ansiedad));
        listaMenu.add(new ItemList("Tips para afrontar entrevista online", "La entrevista on line de igual forma merece ciertos resguardos y cuidados a considerar: .", "Cuida tu foto de perfil y tu nombre de usuario en el programa que utilices para hacer la videoconferencia para mostrar profesionalidad.\n" +
                "Aseg??rate de tener conexi??n a internet y de la calidad de la misma. Evitar??s momentos inc??modos como cortes en el v??deo o en el sonido con el entrevistador.\n" +
                "Vigila la iluminaci??n y el sonido ambiente. Evita espacios oscuros y donde haya mucho ruido para que la calidad del v??deo y del sonido sean ??ptimos.\n" +
                "Elige un buen lugar para hacer la entrevista. Intenta estar solo en el lugar que elijas para realizar la entrevista y as?? evitar distracciones. Es muy importante elegir un espacio ordenado y limpio ya que muchas veces no nos damos cuenta de que, seg??n donde est?? situado el ordenador, el fondo de la habitaci??n tambi??n se ve.\n" +
                "No te olvides de cuidar la imagen. V??stete como si de una entrevista personal se tratase, porque aunque la entrevista sea a trav??s de una pantalla, una imagen vale m??s que mil palabras.\n" +
                "Haz pruebas previas a la entrevista. Aseg??rate de que el programa que utilices est?? actualizado a la ??ltima versi??n y que funciona correctamente. Realiza una videollamada de prueba para comprobar que la conexi??n a internet es la esperada.\n" +
                "S?? puntual, incluso en una cita virtual. Intenta conectarte unos minutos antes y espera de forma paciente y con calma la llamada de tu entrevistador.\n" +
                "Mantener la postura y el tono de voz durante toda la entrevista, mostrar?? seguridad.\n" +
                "Mirar directamente a la c??mara es como si miraras a los ojos a tu entrevistador. As?? mostrar??s que est??s totalmente centrado en la entrevista.\n" +
                "Deja que tu entrevistador sea quien finalice la llamada, as?? evitar??s cortar la conversaci??n y que a tu entrevistador le queden cosas por decirte.", R.drawable.entrevonline));
        listaMenu.add(new ItemList("Tips para negociar sueldo", "Cuando preguntan por tus pretensiones de sueldo, debes considerar lo siguiente:.","Una de las preguntas m??s t??picas y comunes en las entrevistas de trabajo (sea con headhunter o directamente con la compa????a) sobre el salario. Pero que sin la preparaci??n previa, puede ser incomoda e inclusive decisiva a la hora de avanzar en el proceso.\n" +
                "\n" +
                "Son varios los temas que se tratan en una entrevista de trabajo, donde el entrevistador busca conocer en profundidad a los candidatos, desde sus temas personales a logros profesionales, responsabilidades, y hasta temas de competencias y liderazgo, para luego contrarrestar con lo relacionado a expectativas futuras de crecimiento ligado a la pretensi??n salarial.\n" +
                "\n" +
                "Para prepararse a lo anterior, clave es informarse en profundidad de la actividad de la empresa, mercados en los que operan, n??mero de empleados, conocer sus valores corporativos y tambi??n revisar v??nculos o nexos con alguien que haya estado ligado a la compa????a.\n" +
                "\n" +
                "??Qu?? debo responder cuando aparece en la mesa la expectativas salariales? La respuesta correcta es demostrar que independiente del salario a ofrecer, estas interesado por el proyecto, en especial en aquellos casos en los que estamos intentando acceder al mercado laboral por primera vez o relocalizarnos luego de un tiempo reinsert??ndose.\n" +
                "\n" +
                "Pero siempre hay ser claro, tanto la consultora o cliente con los candidatos, como el candidato hacia la oferta, y tenemos hablar directamente del salario que se espera recibir por las responsabilidades descritas en la posici??n, y es ac?? donde hay que mostrar ciertas habilidades de situaci??n y control.\n" +
                "\n" +
                "Para negociar, las personas dentro del proceso de selecci??n debe demostrar que son los profesionales que la empresa est?? buscando, y que su incorporaci??n al equipo humano significar?? un valor a??adido para la organizaci??n, tanto en la operaci??n diaria y como candidato integro, preocupado del talento, de entregar conocimiento y avalar las competencias de liderazgo que est??n buscando. En relaci??n a esto, los logros profesionales adquiridos en experiencias pasadas y actuales, son cr??ticos.\n" +
                "\n" +
                "Si lo ofrecido por la compa????a est?? por debajo de lo esperado, se recomienda evitar rechazar de entrada y poner todos los esfuerzos, de manera respetuosa, clara y con hechos, en lograr aumentarla.\n" +
                "\n" +
                "Adem??s tambi??n se deben tratar aspectos no econ??micos de manera muy clara para poder sopesar, incluir en el paquete anual, y ver si es que equilibran. Entre ellos encontramos la flexibilidad horaria, las posibilidades de desarrollo, capacitaciones, viajes de negocio, bonos, movilizaci??n, seguros, entre otros. De hecho, este factor no monetario ha adquirido cada vez m??s importancia sobre todo en las nuevas generaciones, debido a que se valoran de manera poderosa otras cosas, relacionadas a la calidad de vida, desarrollo profesional y crecimiento.\n" +
                "\n" +
                "??Cu??l es el momento adecuado de tratar este tema?... Para la etapa final, siempre y cuando se haya conversado con el headhunter o consultor, quien entregar?? coach de como liderar este tema, desde dejar en claro si hay capacidad de negociaci??n o de qu?? manera realizarlo. Si es directamente con la compa????a, la negociaci??n se debe hacer una vez el candidato se encuentra en la etapa final del proceso, ya que ya se han puesto sobre la mesa sus competencias, cualidades y existir?? una ventana de negociaci??n frente a lo pretendido.\n" +
                "\n" +
                "No rechazar sin evaluar la primera propuesta, si no cumple con las expectativas, pero el desaf??o interesa, se deber??n colocar en tema los aspectos no econ??micos, y las posibilidades de reajuste siempre con resultados medibles en el corto ??? mediano plazo. Para poder evaluar la propuesta, es clave averiguar cu??l es la banda salarial del mercado por un puesto similar, en ese determinado sector, y seg??n la experiencia del candidato. Demostrar inter??s y motivaci??n por el puesto ayudar?? a sensibilizar la negociaci??n.\n" +
                "\n" +
                "En el caso de llegar a acuerdo, mostrar total disponibilidad, ganas de ser parte de la organizaci??n y lograr confianza con el futuro empleador. En el caso de no ser as??, agradecer la oportunidad y dejar la mejor impresi??n con la compa????a, adem??s de realizar una evaluaci??n del proceso de selecci??n y reflexionar en conjunto con el headhunter donde pueden haber oportunidades de mejora.", R.drawable.sueldo));
        listaMenu.add(new ItemList("??Qu?? debo cuidar antes de firmar un contrato?", "XXXXXXXXXXXXXXXXX.","xsxsxsx", R.drawable.contrato));
        listaMenu.add(new ItemList("??Sirve aprender los test psicol??gicos?", "XXXXXXXX.","xsxsxsx", R.drawable.psicologico));
        listaMenu.add(new ItemList("Listado plataformas para postular a empleo", "En este apartado, te mostramos un listado de plataformas para postular a empleos, las m??s utilizadas.","Laborum.com, Trabajando.com, Computrabajo, GetonBoard, EmpleosPublicos, BNE, AiraVirtual.", R.drawable.plataformas));


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

