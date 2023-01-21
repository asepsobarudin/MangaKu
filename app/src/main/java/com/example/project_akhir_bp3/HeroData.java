package com.example.project_akhir_bp3;

import java.util.ArrayList;

//class ini merupakan class yang digunakan sebagai penyimpanan data.

public class HeroData {

    private static String[] id = {
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
    };

    private static String[] title = {
            "One Punch-Man",
            "Jujutsu Kaisen",
            "Boruto: Naruto Next Generations",
            "Kage no Jitsuryokusha ni Naritakute!",
            "One Piece",
            "Berserk",
            "Vinland Saga",
            "Solo Leveling",
            "Death Note",
            "Chainsaw Man"
    };

    private static String[] synopsis = {
            "After rigorously training for three years, the ordinary Saitama has gained immense strength which allows him to take out anyone and anything with just one punch. He decides to put his new skill to good use by becoming a hero. However, he quickly becomes bored with easily defeating monsters, and wants someone to give him a challenge to bring back the spark of being a hero.\n" +
                    "\n" +
                    "Upon bearing witness to Saitama's amazing power, Genos, a cyborg, is determined to become Saitama's apprentice. During this time, Saitama realizes he is neither getting the recognition that he deserves nor known by the people due to him not being a part of the Hero Association. Wanting to boost his reputation, Saitama decides to have Genos register with him, in exchange for taking him in as a pupil. Together, the two begin working their way up toward becoming true heroes, hoping to find strong enemies and earn respect in the process." ,

            "Hidden in plain sight, an age-old conflict rages on. Supernatural monsters known as \"Curses\" terrorize humanity from the shadows, and powerful humans known as \"Jujutsu\" sorcerers use mystical arts to exterminate them. When high school student Yuuji Itadori finds a dried-up finger of the legendary Curse Sukuna Ryoumen, he suddenly finds himself joining this bloody conflict.\n" +
                    "\n" +
                    "Attacked by a Curse attracted to the finger's power, Yuuji makes a reckless decision to protect himself, gaining the power to combat Curses in the process but also unwittingly unleashing the malicious Sukuna into the world once more. Though Yuuji can control and confine Sukuna to his own body, the Jujutsu world classifies Yuuji as a dangerous, high-level Curse who must be exterminated.\n" +
                    "\n" +
                    "Detained and sentenced to death, Yuuji meets Satoru Gojou—a teacher at Jujutsu High School—who explains that despite his imminent execution, there is an alternative for him. Being a rare vessel to Sukuna, if Yuuji were to die, then Sukuna would perish too. Therefore, if Yuuji were to consume the many other remnants of Sukuna, then Yuuji's subsequent execution would truly eradicate the malicious demon. Taking up this chance to make the world safer and live his life for a little longer, Yuuji enrolls in Jujutsu High, jumping headfirst into a harsh and unforgiving battlefield.",

            "Naruto Uzumaki has finally achieved his dream of becoming Hokage, the leader of the Hidden Leaf Village that he spent his teenage years fighting to protect. Naruto and his peers now live in a world of peace, working hard to uphold an international truce built on good will and diplomacy.\n" +
                    "\n" +
                    "However, this stasis comes at a personal cost for the aging hero. Naruto and the shinobi he grew up alongside find that working to upkeep the neutral world takes them away from their families, and even the legendary warriors of Naruto's generation must contend with being mediocre parents to their bitter children, including his own son Boruto.\n" +
                    "\n" +
                    "Boruto Uzumaki faces a world completely unlike that of his father, finding unique trouble in the distance between the two. Contending with a society that heaps an unbearable load of pressure on his shoulders over his status as the Hokage's son, Boruto carves his own path through the world, fighting to make a name for himself as evil forces threaten to shatter the peace his father helped create.",

            "Shadowbrokers are those who go unnoticed, posing as unremarkable people, when in truth, they control everything from behind the scenes. Sid wants to be someone just like that more than anything, and something as insignificant as boring reality isn't going to get in his way! He trains in secret every single night, preparing for his eventual rise to power—only to denied his destiny by a run-of-the-mill (yet deadly) traffic accident. But when he wakes up in a another world and suddenly finds himself at the head of an actual secret organization doing battle with evil in the shadows, he'll finally get a chance to act out all of his delusional fantasies!",

            "Gol D. Roger, a man referred to as the \"Pirate King,\" is set to be executed by the World Government. But just before his demise, he confirms the existence of a great treasure, One Piece, located somewhere within the vast ocean known as the Grand Line. Announcing that One Piece can be claimed by anyone worthy enough to reach it, the Pirate King is executed and the Great Age of Pirates begins.\n" +
                    "\n" +
                    "Twenty-two years later, a young man by the name of Monkey D. Luffy is ready to embark on his own adventure, searching for One Piece and striving to become the new Pirate King. Armed with just a straw hat, a small boat, and an elastic body, he sets out on a fantastic journey to gather his own crew and a worthy ship that will take them across the Grand Line to claim the greatest status on the high seas.",

            "Guts, a former mercenary now known as the \"Black Swordsman,\" is out for revenge. After a tumultuous childhood, he finally finds someone he respects and believes he can trust, only to have everything fall apart when this person takes away everything important to Guts for the purpose of fulfilling his own desires. Now marked for death, Guts becomes condemned to a fate in which he is relentlessly pursued by demonic beings.\n" +
                    "\n" +
                    "Setting out on a dreadful quest riddled with misfortune, Guts, armed with a massive sword and monstrous strength, will let nothing stop him, not even death itself, until he is finally able to take the head of the one who stripped him—and his loved one—of their humanity.",

            "Thorfinn, son of one of the Vikings' greatest warriors, is among the finest fighters in the merry band of mercenaries run by the cunning Askeladd, an impressive feat for a person his age. However, Thorfinn is not part of the group for the plunder it entails—instead, for having caused his family great tragedy, the boy has vowed to kill Askeladd in a fair duel. Not yet skilled enough to defeat him, but unable to abandon his vengeance, Thorfinn spends his boyhood with the mercenary crew, honing his skills on the battlefield among the war-loving Danes, where killing is just another pleasure of life.\n" +
                    "\n" +
                    "One day, when Askeladd receives word that Danish prince Canute has been taken hostage, he hatches an ambitious plot—one that will decide the next King of England and drastically alter the lives of Thorfinn, Canute, and himself. Set in 11th-century Europe, Vinland Saga tells a bloody epic in an era where violence, madness, and injustice are inescapable, providing a paradise for the battle-crazed and utter hell for the rest who live in it.",

            "Ten years ago, \"the Gate\" appeared and connected the real world with the realm of magic and monsters. To combat these vile beasts, ordinary people received superhuman powers and became known as \"Hunters.\" Twenty-year-old Sung Jin-Woo is one such Hunter, but he is known as the \"World's Weakest,\" owing to his pathetic power compared to even a measly E-Rank. Still, he hunts monsters tirelessly in low-rank Gates to pay for his mother's medical bills.\n" +
                    "\n" +
                    "However, this miserable lifestyle changes when Jin-Woo—believing himself to be the only one left to die in a mission gone terribly wrong—awakens in a hospital three days later to find a mysterious screen floating in front of him. This \"Quest Log\" demands that Jin-Woo completes an unrealistic and intense training program, or face an appropriate penalty. Initially reluctant to comply because of the quest's rigor, Jin-Woo soon finds that it may just transform him into one of the world's most fearsome Hunters.\n",

            "Ryuk, a god of death, drops his Death Note into the human world for personal pleasure. In Japan, prodigious high school student Light Yagami stumbles upon it. Inside the notebook, he finds a chilling message: those whose names are written in it shall die. Its nonsensical nature amuses Light; but when he tests its power by writing the name of a criminal in it, they suddenly meet their demise.\n" +
                    "\n" +
                    "Realizing the Death Note's vast potential, Light commences a series of nefarious murders under the pseudonym \"Kira,\" vowing to cleanse the world of corrupt individuals and create a perfect society where crime ceases to exist. However, the police quickly catch on, and they enlist the help of L—a mastermind detective—to uncover the culprit.\n" +
                    "\n" +
                    "Death Note tells the thrilling tale of Light and L as they clash in a great battle-of-minds, one that will determine the future of the world.",

            "Denji has a simple dream—to live a happy and peaceful life, spending time with a girl he likes. This is a far cry from reality, however, as Denji is forced by the yakuza into killing devils in order to pay off his crushing debts. Using his pet devil Pochita as a weapon, he is ready to do anything for a bit of cash.\n" +
                    "\n" +
                    "Unfortunately, he has outlived his usefulness and is murdered by a devil in contract with the yakuza. However, in an unexpected turn of events, Pochita merges with Denji's dead body and grants him the powers of a chainsaw devil. Now able to transform parts of his body into chainsaws, a revived Denji uses his new abilities to quickly and brutally dispatch his enemies. Catching the eye of the official devil hunters who arrive at the scene, he is offered work at the Public Safety Bureau as one of them. Now with the means to face even the toughest of enemies, Denji will stop at nothing to achieve his simple teenage dreams."
    };

    private static String[] type = {
            "Manga",
            "Manga",
            "Manga",
            "Light Novel",
            "Manga",
            "Manga",
            "Manga",
            "Manhwa",
            "Manga",
            "Manga"
    };

    private static String[] published = {
            "Jun 14, 2012",
            "Mar 5, 2018",
            "May 9, 2016",
            "Nov 5, 2018",
            "Jul 22, 1997",
            "Aug 25, 1989",
            "Apr 13, 2005",
            "Mar 4, 2018",
            "Dec 1, 2003",
            "Dec 3, 2018"
    };

    private static String[] gendre = {
            "Action, Comedy",
            "Action, Fantasy",
            "Action, Adventure, Fantasy",
            "Action, Comedy, Fantasy",
            "Action, Adventure, Fantasy",
            "Action, Adventure, Award Winning, Drama, Fantasy, Horror, Supernatural",
            "Action, Adventure, Award Winning, Drama",
            "Action, Adventure, Fantasy",
            "Supernatural, Suspense",
            "Action, Award Winning, Supernatural"
    };

    private static String[] authors = {
            "Murata, Yusuke (Art), ONE (Story)",
            "Akutami, Gege (Story & Art)",
            "Ikemoto, Mikio (Art), Kodachi, Ukyou (Story)",
            "Touzai (Art), Aizawa, Daisuke (Story)",
            "Oda, Eiichiro (Story & Art)",
            "Miura, Kentarou (Story & Art), Studio Gaga (Art)",
            "Yukimura, Makoto (Story & Art)",
            "Chugong (Story), Jang, Sung-rak (Art)",
            "Obata, Takeshi (Art), Ohba, Tsugumi (Story)",
            "Fujimoto, Tatsuki (Story & Art)"
    };

    private static String[] score = {
            "8.75",
            "8.54",
            "6.82",
            "8.36",
            "9.21",
            "9.46",
            "9.01",
            "8.69",
            "8.70",
            "8.68"
    };

    private static String[] capter = {
            "230",
            "210",
            "77",
            "5",
            "1072",
            "359",
            "198",
            "179",
            "108",
            "118"
    };

    private static int[] imageHero = {
            R.drawable.one_punch_man,
            R.drawable.jujutsu_kaisen,
            R.drawable.boruto,
            R.drawable.kage_no_jitsuryokusha_ni_naritakute,
            R.drawable.one_piece,
            R.drawable.breserk,
            R.drawable.vinlan_saga,
            R.drawable.solo_leveling,
            R.drawable.date_note,
            R.drawable.chainsaw_man
    };

    static ArrayList<Hero> getListData() {
        ArrayList<Hero> list = new ArrayList<>();
        for (int position = 0; position < title.length; position++){
            Hero hero = new Hero();
            hero.setId(id[position]);
            hero.setTitle(title[position]);
            hero.setSynopsis(synopsis[position]);
            hero.setType(type[position]);
            hero.setPublished(published[position]);
            hero.setGendre(gendre[position]);
            hero.setAuthors(authors[position]);
            hero.setScore(score[position]);
            hero.setCapter(capter[position]);
            hero.setPhoto(imageHero[position]);
            list.add(hero);
        }
        return list;
    }
}
