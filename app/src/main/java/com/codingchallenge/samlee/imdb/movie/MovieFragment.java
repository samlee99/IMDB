package com.codingchallenge.samlee.imdb.movie;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.codingchallenge.samlee.imdb.R;
import com.codingchallenge.samlee.imdb.model.InTheater;
import com.codingchallenge.samlee.imdb.model.Movie;
import com.codingchallenge.samlee.imdb.model.Result;
import com.codingchallenge.samlee.imdb.moviedetail.MovieDetailActivity;
import com.codingchallenge.samlee.imdb.utils.ConvertUtil;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by samlee on 3/2/18.
 */

public class MovieFragment extends Fragment implements MovieContract.View {

    private MovieContract.Presenter mPresenter;

    private RecyclerView mRecyclerView;

    private MovieAdapter mMovieAdapter;

//    public final static String LIST_STATE_KEY = "recycler_list_state";
//    Parcelable mListState;

    public MovieFragment() {

    }

    public static MovieFragment newInstance() {
        return new MovieFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_movie, container, false);

        Gson gson = new Gson();
        String json = "{\"data\":{\"inTheaters\":[{\"openingThisWeek\":\"Opening This Week\",\"movies\":[{\"title\":\"Red Sparrow\",\"originalTitle\":\"\",\"year\":\"2018\",\"releaseDate\":\"20180302\",\"directors\":[{\"name\":\"Francis Lawrence\",\"id\":\"nm1349376\"}],\"writers\":[{\"name\":\"Justin Haythe\",\"id\":\"nm1244808\"},{\"name\":\"Jason Matthews\",\"id\":\"nm5645796\"}],\"runtime\":\"139 min\",\"urlPoster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BMTA3MDkxOTc4NDdeQTJeQWpwZ15BbWU4MDAxNzgyNTQz._V1_UX182_CR0,0,182,268_AL_.jpg\",\"countries\":[\"USA\"],\"languages\":[\"English\"],\"genres\":[\"Mystery\",\"Thriller\"],\"plot\":\"A young Russian intelligence officer is assigned to seduce a first-tour CIA agent who handles the CIA's most sensitive penetration of Russian intelligence. The two young officers collide in a charged atmosphere of trade-craft, deception, and inevitably forbidden passion that threatens not just their lives but the lives of others as well.\",\"simplePlot\":\"Ballerina Dominika Egorova is recruited to 'Sparrow School' a Russian intelligence service where she is forced to use her body as a weapon. But her first mission, targeting a CIA agent, threatens to unravel the security of both nations.\",\"idIMDB\":\"tt2873282\",\"urlIMDB\":\"http://www.imdb.com/title/tt2873282\",\"rated\":\"R\",\"type\":\"Movie\"},{\"title\":\"They Remain\",\"originalTitle\":\"\",\"year\":\"2018\",\"releaseDate\":\"20180128\",\"directors\":[{\"name\":\"Philip Gelatt\",\"id\":\"nm3664884\"}],\"writers\":[{\"name\":\"Laird Barron\",\"id\":\"nm7624912\"},{\"name\":\"Philip Gelatt\",\"id\":\"nm3664884\"}],\"urlPoster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BMjI0NTEzMTk1OV5BMl5BanBnXkFtZTgwNTMwNDY3NDM@._V1_UY268_CR3,0,182,268_AL_.jpg\",\"countries\":[\"USA\"],\"languages\":[\"English\"],\"genres\":[\"Thriller\"],\"plot\":\"Two scientists who share a romantic history are tasked with investigating unnatural animal behaviour on the site of a Manson Family-style cult's compound.\",\"simplePlot\":\"Two scientists who share a romantic history are tasked with investigating unnatural animal behaviour on the site of a Manson Family-style cult's compound.\",\"idIMDB\":\"tt4991112\",\"urlIMDB\":\"http://www.imdb.com/title/tt4991112\",\"rating\":\"7.8\",\"votes\":\"13\",\"type\":\"Movie\"},{\"title\":\"Death Wish\",\"originalTitle\":\"\",\"year\":\"2018\",\"releaseDate\":\"20180302\",\"directors\":[{\"name\":\"Eli Roth\",\"id\":\"nm0744834\"}],\"writers\":[{\"name\":\"Joe Carnahan\",\"id\":\"nm0138620\"},{\"name\":\"Brian Garfield\",\"id\":\"nm0307257\"}],\"runtime\":\"108 min\",\"urlPoster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BMTkzNjU3MjE0MF5BMl5BanBnXkFtZTgwNTIyNDk0NDM@._V1_UX182_CR0,0,182,268_AL_.jpg\",\"countries\":[\"USA\"],\"languages\":[\"English\"],\"genres\":[\"Action\",\"Crime\",\"Drama\",\"Thriller\"],\"plot\":\"Dr. Paul Kersey (Bruce Willis) is a surgeon who only sees the aftermath of his city's violence as it's rushed into his ER -until his wife (Elisabeth Shue) and college-age daughter (Camila Morrone) are viciously attacked in their suburban home. With the police overloaded with crimes, Paul, burning for revenge, hunts for his family's assailants to deliver justice. As the anonymous slayings of criminals grabs the media's attention, the city wonders if this deadly avenger is a guardian angel...or a grim reaper. Fury and fate collide in the intense action-thriller Death Wish.\",\"simplePlot\":\"A family man becomes a vigilante killing machine when his family is violently attacked by robbers.\",\"idIMDB\":\"tt1137450\",\"urlIMDB\":\"http://www.imdb.com/title/tt1137450\",\"rated\":\"R\",\"type\":\"Movie\"},{\"title\":\"Submission\",\"originalTitle\":\"\",\"year\":\"2017\",\"releaseDate\":\"20171013\",\"directors\":[{\"name\":\"Richard Levine\",\"id\":\"nm0505934\"}],\"writers\":[{\"name\":\"Richard Levine\",\"id\":\"nm0505934\"},{\"name\":\"Francine Prose\",\"id\":\"nm0698731\"}],\"urlPoster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BMjQ4NDkwMzM4OF5BMl5BanBnXkFtZTgwNzE3MzI3NDM@._V1_UX182_CR0,0,182,268_AL_.jpg\",\"countries\":[\"USA\"],\"languages\":[],\"genres\":[\"Drama\"],\"plot\":\"A cynical college professor takes a keen interest in a talented young writing student.\",\"simplePlot\":\"A cynical college professor takes a keen interest in a talented young writing student.\",\"idIMDB\":\"tt2707810\",\"urlIMDB\":\"http://www.imdb.com/title/tt2707810\",\"rating\":\"6.1\",\"votes\":\"15\",\"type\":\"Movie\"},{\"title\":\"Foxtrot\",\"originalTitle\":\"\",\"year\":\"2017\",\"releaseDate\":\"20180425\",\"directors\":[{\"name\":\"Samuel Maoz\",\"id\":\"nm1413443\"}],\"writers\":[{\"name\":\"Samuel Maoz\",\"id\":\"nm1413443\"}],\"runtime\":\"108 min\",\"urlPoster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BOGUyZTJhZWEtNGIwZi00YjUwLTljMGMtNjliMzM1NDMxYjJmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_UY268_CR3,0,182,268_AL_.jpg\",\"countries\":[\"Israel\",\"Switzerland\",\"Germany\",\"France\"],\"languages\":[\"Hebrew\"],\"genres\":[\"Drama\"],\"plot\":\"A troubled family face the facts when something goes terribly wrong at their son's desolate military post.\",\"simplePlot\":\"A troubled family face the facts when something goes terribly wrong at their son's desolate military post.\",\"idIMDB\":\"tt6896536\",\"urlIMDB\":\"http://www.imdb.com/title/tt6896536\",\"rating\":\"7.4\",\"metascore\":\"92\",\"rated\":\"R\",\"votes\":\"974\",\"type\":\"Movie\"},{\"title\":\"Souvenir\",\"originalTitle\":\"\",\"year\":\"2016\",\"releaseDate\":\"20161221\",\"directors\":[{\"name\":\"Bavo Defurne\",\"id\":\"nm0214618\"}],\"writers\":[{\"name\":\"Bavo Defurne\",\"id\":\"nm0214618\"},{\"name\":\"Jacques Boon\",\"id\":\"nm0095464\"}],\"runtime\":\"90 min\",\"urlPoster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BZmJkZjVhNGUtOTg4MC00YzAwLTg4ZjEtZjAxYmVlNTlkOTgyXkEyXkFqcGdeQXVyNTQwMDA5NTg@._V1_UX182_CR0,0,182,268_AL_.jpg\",\"countries\":[\"Belgium\",\"Luxembourg\",\"France\"],\"languages\":[\"French\"],\"genres\":[\"Drama\",\"Music\",\"Romance\"],\"plot\":\"Because of the stupid life in a pâté-factory, former singer Laura falls in love with a colleague, a much younger boy and boxer, and after a small performance, a reenactment of her singing character, she tries to reenter the national song contest.\",\"simplePlot\":\"A forgotten European Song Contest singer, fading away in a pâté factory, falls in love with a young aspiring boxer. Together they decide to attempt her comeback.\",\"idIMDB\":\"tt2387692\",\"urlIMDB\":\"http://www.imdb.com/title/tt2387692\",\"rating\":\"6.1\",\"rated\":\"TOUS PUBLICS\",\"votes\":\"582\",\"type\":\"Movie\"},{\"title\":\"Dance Academy: The Movie\",\"originalTitle\":\"\",\"year\":\"2017\",\"releaseDate\":\"20180302\",\"directors\":[{\"name\":\"Jeffrey Walker\",\"id\":\"nm0907835\"}],\"writers\":[{\"name\":\"Samantha Strauss\",\"id\":\"nm1787259\"}],\"runtime\":\"101 min\",\"urlPoster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BYjg2MzMwYmYtNjkwMS00N2VmLWI2MDMtMDA2ZjZiMDBkZDk1L2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyNTg3ODAyOTY@._V1_UY268_CR16,0,182,268_AL_.jpg\",\"countries\":[\"Australia\",\"Germany\"],\"languages\":[\"English\"],\"genres\":[\"Drama\"],\"plot\":\"This 2017 movie follows the original dance academy TV show and tracks where the characters are in their lives now.\",\"simplePlot\":\"This 2017 movie follows the original dance academy TV show and tracks where the characters are in their lives now.\",\"idIMDB\":\"tt5834660\",\"urlIMDB\":\"http://www.imdb.com/title/tt5834660\",\"rating\":\"7.0\",\"votes\":\"573\",\"type\":\"Movie\"}]},{\"inTheatersNow\":\"In Theaters Now\",\"movies\":[{\"title\":\"Peter Rabbit\",\"originalTitle\":\"\",\"year\":\"2018\",\"releaseDate\":\"20180209\",\"directors\":[{\"name\":\"Will Gluck\",\"id\":\"nm0323239\"}],\"writers\":[{\"name\":\"Rob Lieber\",\"id\":\"nm1464577\"},{\"name\":\"Will Gluck\",\"id\":\"nm0323239\"}],\"runtime\":\"93 min\",\"urlPoster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BMTk5NzI0ODUwN15BMl5BanBnXkFtZTgwOTIxNjA0NDM@._V1_UX182_CR0,0,182,268_AL_.jpg\",\"countries\":[\"UK\",\"Australia\",\"USA\"],\"languages\":[\"English\"],\"genres\":[\"Animation\",\"Adventure\",\"Comedy\",\"Family\",\"Fantasy\"],\"plot\":\"Feature adaptation of Beatrix Potter's classic tale of a rebellious rabbit trying to sneak into a farmer's vegetable garden.\",\"simplePlot\":\"Feature adaptation of Beatrix Potter's classic tale of a rebellious rabbit trying to sneak into a farmer's vegetable garden.\",\"idIMDB\":\"tt5117670\",\"urlIMDB\":\"http://www.imdb.com/title/tt5117670\",\"rating\":\"6.1\",\"metascore\":\"52\",\"rated\":\"PG\",\"votes\":\"994\",\"type\":\"Movie\"},{\"title\":\"Black Panther\",\"originalTitle\":\"\",\"year\":\"2018\",\"releaseDate\":\"20180216\",\"directors\":[{\"name\":\"Ryan Coogler\",\"id\":\"nm3363032\"}],\"writers\":[{\"name\":\"Ryan Coogler\",\"id\":\"nm3363032\"},{\"name\":\"Joe Robert Cole\",\"id\":\"nm1963288\"}],\"runtime\":\"134 min\",\"urlPoster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BMTg1MTY2MjYzNV5BMl5BanBnXkFtZTgwMTc4NTMwNDI@._V1_UX182_CR0,0,182,268_AL_.jpg\",\"countries\":[\"USA\"],\"languages\":[\"English\"],\"genres\":[\"Action\",\"Adventure\",\"Sci-Fi\"],\"plot\":\"After the events of Captain America: Civil War, King T'Challa returns home to the reclusive, technologically advanced African nation of Wakanda to serve as his country's new leader. However, T'Challa soon finds that he is challenged for the throne from factions within his own country. When two foes conspire to destroy Wakanda, the hero known as Black Panther must team up with C.I.A. agent Everett K. Ross and members of the Dora Milaje, Wakandan special forces, to prevent Wakanda from being dragged into a world war.\",\"simplePlot\":\"T'Challa, after the death of his father, the King of Wakanda, returns home to the isolated, technologically advanced African nation to succeed to the throne and take his rightful place as king.\",\"idIMDB\":\"tt1825683\",\"urlIMDB\":\"http://www.imdb.com/title/tt1825683\",\"rating\":\"7.1\",\"metascore\":\"87\",\"rated\":\"PG-13\",\"votes\":\"18,099\",\"type\":\"Movie\"},{\"title\":\"Fifty Shades Freed\",\"originalTitle\":\"\",\"year\":\"2018\",\"releaseDate\":\"20180209\",\"directors\":[{\"name\":\"James Foley\",\"id\":\"nm0001226\"}],\"writers\":[{\"name\":\"Niall Leonard\",\"id\":\"nm0502727\"},{\"name\":\"E.L. James\",\"id\":\"nm1093317\"}],\"runtime\":\"105 min\",\"urlPoster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BMTYxOTQ1MzI0Nl5BMl5BanBnXkFtZTgwMzgwMzIxNDM@._V1_UX182_CR0,0,182,268_AL_.jpg\",\"countries\":[\"USA\"],\"languages\":[\"English\"],\"genres\":[\"Drama\",\"Romance\",\"Thriller\"],\"plot\":\"Believing they have left behind shadowy figures from their past, newlyweds Christian and Ana fully embrace an inextricable connection and shared life of luxury. But just as she steps into her role as Mrs. Grey and he relaxes into an unfamiliar stability, new threats could jeopardize their happy ending before it even begins.\",\"simplePlot\":\"Anastasia and Christian get married, but Jack Hyde continues to threaten their relationship.\",\"idIMDB\":\"tt4477536\",\"urlIMDB\":\"http://www.imdb.com/title/tt4477536\",\"rating\":\"4.2\",\"metascore\":\"32\",\"rated\":\"R\",\"votes\":\"7,719\",\"type\":\"Movie\"},{\"title\":\"The 15:17 to Paris\",\"originalTitle\":\"\",\"year\":\"2018\",\"releaseDate\":\"20180209\",\"directors\":[{\"name\":\"Clint Eastwood\",\"id\":\"nm0000142\"}],\"writers\":[{\"name\":\"Dorothy Blyskal\",\"id\":\"nm2980113\"},{\"name\":\"Anthony Sadler\",\"id\":\"nm7582805\"}],\"runtime\":\"94 min\",\"urlPoster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BMTY0NjUzNjYwOV5BMl5BanBnXkFtZTgwMzY1MDM0NDM@._V1_UX182_CR0,0,182,268_AL_.jpg\",\"countries\":[\"USA\"],\"languages\":[\"English\"],\"genres\":[\"Drama\",\"History\",\"Thriller\"],\"plot\":\"In the early evening of August 21, 2015, the world watched in stunned silence as the media reported a thwarted terrorist attack on Thalys train #9364 bound for Paris--an attempt prevented by three courageous young Americans traveling through Europe. The film follows the course of the friends' lives, from the struggles of childhood through finding their footing in life, to the series of unlikely events leading up to the attack. Throughout the harrowing ordeal, their friendship never wavers, making it their greatest weapon and allowing them to save the lives of the more than 500 passengers on board.\",\"simplePlot\":\"Three Americans discover a terrorist plot aboard a train while in France.\",\"idIMDB\":\"tt6802308\",\"urlIMDB\":\"http://www.imdb.com/title/tt6802308\",\"rating\":\"5.1\",\"metascore\":\"44\",\"rated\":\"PG-13\",\"votes\":\"2,654\",\"type\":\"Movie\"},{\"title\":\"Jumanji: Welcome to the Jungle\",\"originalTitle\":\"\",\"year\":\"2017\",\"releaseDate\":\"20171220\",\"directors\":[{\"name\":\"Jake Kasdan\",\"id\":\"nm0440458\"}],\"writers\":[{\"name\":\"Chris McKenna\",\"id\":\"nm0571344\"},{\"name\":\"Erik Sommers\",\"id\":\"nm1273099\"}],\"runtime\":\"119 min\",\"urlPoster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BMTkyNDQ1MDc5OV5BMl5BanBnXkFtZTgwOTcyNzI2MzI@._V1_UX182_CR0,0,182,268_AL_.jpg\",\"countries\":[\"USA\"],\"languages\":[\"English\"],\"genres\":[\"Action\",\"Adventure\",\"Comedy\",\"Fantasy\"],\"plot\":\"In a brand new Jumanji adventure, four high school kids discover an old video game console and are drawn into the game's jungle setting, literally becoming the adult avatars they chose. What they discover is that you don't just play Jumanji - you must survive it. To beat the game and return to the real world, they'll have to go on the most dangerous adventure of their lives, discover what Alan Parrish left 20 years ago, and change the way they think about themselves - or they'll be stuck in the game forever, to be played by others without break.\",\"simplePlot\":\"Four teenagers are sucked into a magical video game, and the only way they can escape is to work together to finish the game.\",\"idIMDB\":\"tt2283362\",\"urlIMDB\":\"http://www.imdb.com/title/tt2283362\",\"rating\":\"7.2\",\"metascore\":\"58\",\"rated\":\"PG-13\",\"votes\":\"71,407\",\"type\":\"Movie\"},{\"title\":\"The Greatest Showman\",\"originalTitle\":\"\",\"year\":\"2017\",\"releaseDate\":\"20171220\",\"directors\":[{\"name\":\"Michael Gracey\",\"id\":\"nm1243905\"}],\"writers\":[{\"name\":\"Jenny Bicks\",\"id\":\"nm0081081\"},{\"name\":\"Bill Condon\",\"id\":\"nm0174374\"}],\"runtime\":\"105 min\",\"urlPoster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BYjQ0ZWJkYjMtYjJmYS00MjJiLTg3NTYtMmIzN2E2Y2YwZmUyXkEyXkFqcGdeQXVyNjk5NDA3OTk@._V1_UX182_CR0,0,182,268_AL_.jpg\",\"countries\":[\"USA\"],\"languages\":[\"English\"],\"genres\":[\"Biography\",\"Drama\",\"Musical\",\"Romance\"],\"plot\":\"Orphaned, penniless but ambitious and with a mind crammed with imagination and fresh ideas, the American Phineas Taylor Barnum will always be remembered as the man with the gift to effortlessly blur the line between reality and fiction. Thirsty for innovation and hungry for success, the son of a tailor will manage to open a wax museum but will soon shift focus to the unique and peculiar, introducing extraordinary, never-seen-before live acts on the circus stage. Some will call Barnum's wide collection of oddities, a freak show; however, when the obsessed for cheers and respectability showman gambles everything on the opera singer Jenny Lind to appeal to a high-brow audience, he will somehow lose sight of the most important aspect of his life: his family. Will Barnum risk it all to be accepted?\",\"simplePlot\":\"Celebrates the birth of show business, and tells of a visionary who rose from nothing to create a spectacle that became a worldwide sensation.\",\"idIMDB\":\"tt1485796\",\"urlIMDB\":\"http://www.imdb.com/title/tt1485796\",\"rating\":\"8.0\",\"metascore\":\"48\",\"rated\":\"PG\",\"votes\":\"66,409\",\"type\":\"Movie\"},{\"title\":\"Early Man\",\"originalTitle\":\"\",\"year\":\"2018\",\"releaseDate\":\"20180216\",\"directors\":[{\"name\":\"Nick Park\",\"id\":\"nm0661910\"}],\"writers\":[{\"name\":\"Mark Burton\",\"id\":\"nm0123666\"},{\"name\":\"James Higginson\",\"id\":\"nm2664949\"}],\"runtime\":\"89 min\",\"urlPoster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BYWMxYWVjNzAtMTY0YS00YWQyLWExMGItMjUxODkwYzQyNzMwXkEyXkFqcGdeQXVyMjMxOTE0ODA@._V1_UX182_CR0,0,182,268_AL_.jpg\",\"countries\":[\"UK\",\"France\"],\"languages\":[\"English\"],\"genres\":[\"Animation\",\"Adventure\",\"Comedy\",\"Family\",\"Fantasy\"],\"plot\":\"Set at the dawn of time, when prehistoric creatures and woolly mammoths roamed the earth, Early Man tells the story of Dug, along with sidekick Hognob as they unite his tribe against a mighty enemy Lord Nooth and his Bronze Age City to save their home.\",\"simplePlot\":\"Set at the dawn of time, when prehistoric creatures and woolly mammoths roamed the earth, Early Man tells the story of Dug, along with sidekick Hognob as they unite his tribe against a mighty enemy Lord Nooth and his Bronze Age City to save their home.\",\"idIMDB\":\"tt4701724\",\"urlIMDB\":\"http://www.imdb.com/title/tt4701724\",\"rating\":\"6.3\",\"metascore\":\"66\",\"rated\":\"PG\",\"votes\":\"1,422\",\"type\":\"Movie\"},{\"title\":\"Winchester\",\"originalTitle\":\"\",\"year\":\"2018\",\"releaseDate\":\"20180202\",\"directors\":[{\"name\":\"Michael Spierig\",\"id\":\"nm1294961\"},{\"name\":\"Peter Spierig\",\"id\":\"nm1294962\"}],\"writers\":[{\"name\":\"Tom Vaughan\",\"id\":\"nm1129343\"},{\"name\":\"Michael Spierig\",\"id\":\"nm1294961\"}],\"runtime\":\"99 min\",\"urlPoster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BMjI2OWE5OGItMTE4Yi00ZmIzLThjZDctNTU1OTMxMTc3Yjg4XkEyXkFqcGdeQXVyMjM4NTM5NDY@._V1_UX182_CR0,0,182,268_AL_.jpg\",\"countries\":[\"Australia\",\"USA\"],\"languages\":[\"English\"],\"genres\":[\"Biography\",\"Fantasy\",\"Horror\",\"Mystery\",\"Thriller\"],\"plot\":\"Inspired by true events. On an isolated stretch of land 50 miles outside of San Francisco sits the most haunted house in the world. Built by Sarah Winchester, (Academy Award®-winner Helen Mirren) heiress to the Winchester fortune, it is a house that knows no end. Constructed in an incessant twenty-four hour a day, seven day a week mania for decades, it stands seven stories tall and contains hundreds of rooms. To the outsider it looks like a monstrous monument to a disturbed woman's madness. But Sarah is not building for herself, for her niece (Sarah Snook) or for the brilliant Doctor Eric Price (Jason Clarke) whom she has summoned to the house. She is building a prison, an asylum for hundreds of vengeful ghosts, and the most terrifying among them have a score to settle with the Winchesters.\",\"simplePlot\":\"Ensconced in her sprawling California mansion, eccentric firearm heiress Sarah Winchester believes she is haunted by the souls of people killed by the Winchester repeating rifle.\",\"idIMDB\":\"tt1072748\",\"urlIMDB\":\"http://www.imdb.com/title/tt1072748\",\"rating\":\"5.3\",\"metascore\":\"28\",\"rated\":\"PG-13\",\"votes\":\"2,637\",\"type\":\"Movie\"},{\"title\":\"The Post\",\"originalTitle\":\"\",\"year\":\"2017\",\"releaseDate\":\"20180112\",\"directors\":[{\"name\":\"Steven Spielberg\",\"id\":\"nm0000229\"}],\"writers\":[{\"name\":\"Liz Hannah\",\"id\":\"nm2176283\"},{\"name\":\"Josh Singer\",\"id\":\"nm1802857\"}],\"runtime\":\"116 min\",\"urlPoster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BMjQyMjEwOTIwNV5BMl5BanBnXkFtZTgwOTkzNTMxNDM@._V1_UX182_CR0,0,182,268_AL_.jpg\",\"countries\":[\"UK\",\"USA\"],\"languages\":[\"English\"],\"genres\":[\"Biography\",\"Drama\",\"History\",\"Thriller\"],\"plot\":\"When American military analyst, Daniel Ellsberg, realizes to his disgust the depths of the US government's deceptions about the futility of the Vietnam War, he takes action by copying top-secret documents that would become the Pentagon Papers. Later, Washington Post owner, Kay Graham, is still adjusting to taking over her late husband's business when editor Ben Bradlee discovers the New York Times has scooped them with an explosive expose on those papers. Determined to compete, Post reporters find Ellsberg himself and a complete copy of those papers. However, the Post's plans to publish their findings are put in jeopardy with a Federal restraining order that could get them all indicted for Contempt. Now, Kay Graham must decide whether to back down for the safety of her paper or publish and fight for the Freedom of the Press. In doing so, Graham and her staff join a fight that would have America's democratic ideals in the balance.\",\"simplePlot\":\"A cover-up that spanned four U.S. Presidents pushed the country's first female newspaper publisher and a hard-driving editor to join an unprecedented battle between the press and the government.\",\"idIMDB\":\"tt6294822\",\"urlIMDB\":\"http://www.imdb.com/title/tt6294822\",\"rating\":\"7.4\",\"metascore\":\"83\",\"rated\":\"PG-13\",\"votes\":\"35,939\",\"type\":\"Movie\"},{\"title\":\"Maze Runner: The Death Cure\",\"originalTitle\":\"\",\"year\":\"2018\",\"releaseDate\":\"20180126\",\"directors\":[{\"name\":\"Wes Ball\",\"id\":\"nm1226871\"}],\"writers\":[{\"name\":\"T.S. Nowlin\",\"id\":\"nm2385905\"},{\"name\":\"James Dashner\",\"id\":\"nm4212895\"}],\"runtime\":\"141 min\",\"urlPoster\":\"https://images-na.ssl-images-amazon.com/images/M/MV5BMTYyNzk3MDc2NF5BMl5BanBnXkFtZTgwMDk3OTM1NDM@._V1_UX182_CR0,0,182,268_AL_.jpg\",\"countries\":[\"USA\"],\"languages\":[\"English\"],\"genres\":[\"Action\",\"Sci-Fi\",\"Thriller\"],\"plot\":\"In the epic finale to The Maze Runner Saga, Thomas leads his group of escaped Gladers on their final and most dangerous mission yet. To save their friends, they must break into the legendary last city, a WCKD controlled labyrinth that may turn out to be the deadliest maze of all. Anyone who makes it out alive will get the answers to the questions the Gladers have been asking since they first arrived in the maze. Will Thomas and the crew make it out alive? Or will Ava Paige get her way?\",\"simplePlot\":\"Young hero Thomas embarks on a mission to find a cure for a deadly disease known as the \\\"Flare\\\".\",\"idIMDB\":\"tt4500922\",\"urlIMDB\":\"http://www.imdb.com/title/tt4500922\",\"rating\":\"6.9\",\"metascore\":\"51\",\"rated\":\"PG-13\",\"votes\":\"21,340\",\"type\":\"Movie\"}]}]},\"about\":{\"version\":\"2.34.0\",\"serverTime\":\"2018/03/04 19:07:45\"}}";

        Result result = gson.fromJson(json, Result.class);
        List<InTheater> inTheaterList = result.getData().getInTheaters();
        List<Movie> moviesList = new ArrayList<>();
        for(InTheater theater : inTheaterList) {
//            if (theater.getInTheatersNow() != null) {
                moviesList.addAll(theater.getMovies());
//            }
        }

        mRecyclerView = root.findViewById(R.id.movieRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setHasFixedSize(true);

        mMovieAdapter = new MovieAdapter(moviesList);
        mRecyclerView.setAdapter(mMovieAdapter);

        return root;
    }

//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//
//        mListState = mRecyclerView.getLayoutManager().onSaveInstanceState();
//        outState.putParcelable(LIST_STATE_KEY, mListState);
//    }
//
//    @Override
//    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
//        super.onViewStateRestored(savedInstanceState);
//
//        if (mListState != null) {
//            mListState = savedInstanceState.getParcelable(LIST_STATE_KEY);
//        }
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        if (mListState != null) {
//            mRecyclerView.getLayoutManager().onRestoreInstanceState(mListState);
//        }
//    }

    @Override
    public void showMoviesList() {

    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void setPresenter(MovieContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    public static class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

        private List<Movie> mMovieList;

        public MovieAdapter(List<Movie> movies) {
            this.mMovieList = movies;
        }

        @Override
        public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_movies, parent, false);
            return new MovieViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MovieViewHolder holder, int position) {
            // TODO: Initialize all the movie photos, titles, details, and onclicks.

            final Movie movie = mMovieList.get(position);

            Picasso.with(holder.mMovieCoverImageView.getContext()).load(movie.getUrlPoster()).fit().into(holder.mMovieCoverImageView);
            holder.mMovieTitleTextView.setText(movie.getTitle());

            String rated = movie.getRated();
            String runtime = ConvertUtil.convertMinutesToHrMin(movie.getRuntime());
            String genre = movie.getGenres().get(0);
            holder.mMovieDetailTextView.setText((rated == null ? "Not Rated" : rated) + " | " + (runtime == null ? genre : runtime + " | " + genre));

            holder.mViewDetailsTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // TODO: Start moviedetail activity with passed in parameters of movie selected.
//                    Toast.makeText(view.getContext(), "Testing view details!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(view.getContext(), MovieDetailActivity.class);
                    intent.putExtra("movieObject", movie);
                    view.getContext().startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mMovieList.size();
        }

        public class MovieViewHolder extends RecyclerView.ViewHolder {
            private ImageView mMovieCoverImageView;
            private TextView mMovieTitleTextView, mMovieDetailTextView, mViewDetailsTextView;

            public MovieViewHolder(View itemView) {
                super(itemView);

                mMovieCoverImageView = itemView.findViewById(R.id.movieCoverImageView);
                mMovieTitleTextView = itemView.findViewById(R.id.movieTitleTextView);
                mMovieDetailTextView = itemView.findViewById(R.id.movieDetailTextView);
                mViewDetailsTextView = itemView.findViewById(R.id.viewDetailsTextView);
            }
        }
    }
}
