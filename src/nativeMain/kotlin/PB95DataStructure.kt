data class PB95Data(// mostly following the savefile tradition
	// should do smt to process data that isnt in code
	val gameWallpaperSaves: OSValueMap,
	val upgradeSTG: Int, // not sure
	val gameScoreCurrent: Int,
	val playTime: Long, // in ms? not sure
	val overallStartCount: Int, // not sure
	val gameSpecialSkins: HashSet<SpecialOSSkin>,
	val osRegularUpdateSTG: Int,
	val inGameKeyboard: Boolean,
	val wallpaperSaves: OSValueMap, // not sure wts the diff btwn gameWallpaperSaves
	val overrideHDDNoise: Boolean,
	val specialSkinsPurchased: HashSet<SpecialOSSkin>, // again, wts the diff btwn gameSpecialSkins
	val statistics: Statistics,
	val gameStagesSaves: OSValueMap,
	val osInstalledList: InstalledOS,
	val allowCloudSaving: Boolean, // i think this is just 0 / 1, so ill use bool
	val cheatCodeUsed: HashMap<Cheats, ArrayList<Int>>, // not gonna get what List<Int> gives
	val overrideCRT: Boolean,
	val like: Int, // ok what is this
	val scoreCollection: Int, // ok what is this
	val shutdownBonus: Int,
	val day: Int,
	val consent: Int, // ? what
	val tutorialTip: HashMap<TutorialTip, Int>,
	val purchasedItemList: String, // is a string, but probably a list
	val gameDutyTaskBack: Int,
	val rmrf: Boolean,
	val gameDutyNews: Int,
	val gameModesPurchased: HashSet<String>,
	val dutyServices: DutyServices,
	val system32WasRemoved: Boolean,
	val version: Boolean,
	val datesInARow: Int,
	val appLanguage: String, // todo: use libraries mb
	val colorBlindness: Boolean,
	val gameDutyTask: Int,
	val bestStagesSaves: OSValueMap
)

data class DutyServices(
	val haptic: Boolean,
	val playerAchievementListOld: HashSet<Achievements>,
	val os: StringSGF, // todo
	val bit8SaveSlots: HashSet<StringSGF>, // todo
	val pointer: OSValueMap,
	val themes: OSValueMap,
	val barScore: Int,
	val pHard: Hardware,
	val taskbar: Int,
	val myPageHeadImage2: String,
	val blueTick: Boolean,
	val bar8Score: Int,
	val wirecutter: Boolean,
	val volume: Int,
	val originalVersion: Int,
	val playerAchievementList: HashSet<Achievements>,
	val userPic: Int,
	val backgroundColors: HashMap<PB95OS, ArrayList<Color>>,
	val counterWarning: Int,
	val favourites: HashSet<String>,
	val myPageHeadImage3: String,
	val shaderOn: Boolean,
	val unlockedItems: StringSGF, // todo
	val gpuType: Int,
	val bcIntroTheme: String,
	val productKeys: Int,
	val cursor: Boolean,
	val myPageTextColor: MutableList<Color>,
	val binStatus: BinStatus,
	val virtualMemory: Int,
	val cursorTrail: Boolean,
	val progressData: Long,
	val reduceFlashes: Boolean,
	val enlargeText: Boolean,
	val myPageHeadImage1: String,
	val downloadListCurrent: MutableList<String>,
	val username: String,
	val ramType: Int,
	val panelPlume: Boolean,
	val musicThemeUpgrade: Int,
	val displayMode: Int,
	val lanTime: Long,
	val progressionScore: Int,
	val h24: Int,
	val wallpapepPlacement: Int,
	val sysYear: Boolean,
	val logonScreen: Int,
	val myPageBack: String,
	val myPageTextStyle: String,
	val lan: StringSGF, // todo
	val customdifficultySave: MutableList<String>, // spelt CustomDificultySave
	val screwdriver: Boolean,
	val pBookPosts: Int,
	val font: OSValueMap,
	val year: Int,
	val chlg: StringSGF, // todo
	val hddType: Int,
	val browser: StringSGF, // todo
	val previousDGun: Int,
	val musicVolume: Int
)

abstract class StringSGF(open val set: Set<Any>) {
	fun saveGameFormat(): String = " " + set.joinToString { it.toString() }
}

data class Hardware(val gpu: ArrayList<Int>, val ram: ArrayList<Int>) // todo: limit to 2 entries
data class OSValueMap(val map: HashMap<PB95OS, Int>)
data class BinStatus(val mood: Double, val food: Int)
data class Color(val r: Int, val g: Int, val b: Int) // todo: use a library
data class InstalledOS(override val set: Set<PB95OS>): StringSGF(set)
data class Statistics(val map: HashMap<Statistic, Int>) {
	// marking in what the savefile gives
	enum class Statistic { Dogs, Errors, pinball, defender, Bugs, Points, Red, Normal, Bsod, Hardcore, Correct, Presents, Relax, minesweeper, Progressoid, xl, progresscommander, progresstein }
}

interface PB95OS
enum class PBOS: PB95OS { P95, P98 }
enum class BarOS: PB95OS { BA1, BA2, BA3, BA4, BA5, BA6, BA7, BA8, BA9, B10, B11, B12, B13, B14, B15, B16, BX1, BOS }
enum class EightBitOS: PB95OS
enum class SpecialOSSkin: PB95OS

enum class Cheats { Popup, Blue, Godmode }
enum class TutorialTip { DtPrtn, p96, usecheat, closetask, hey10, customgame, xlgame, sol, confetti, pbbr, VD, Idle, PB7, progresscommander, entcht, ml, Ball, idle, GenerateButton, BinPet, defender, BOS, progresstris, sweeper, Tag }
enum class Achievements // todo