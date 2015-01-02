package org.mdo.tools.game.teso

import groovy.json.JsonBuilder

/**
 * @author MDO
 * @since 30/12/2014
 */
class Application {

    static def ITEMS = [
            [
                    image: "http://static.mnium.org/images/contenu/actus/mmorpg/the_elder_scrolls_online/artisanat/alchimie/teso_absinthe.jpg",
                    name :
                            [
                                    en: "Wormwood",
                                    fr: "Absinthe",
                            ],
                    e1   : [fr: "Arme critique",],
                    e2   : [fr: "Détection",],
                    e3   : [fr: "Réduit la vitesse",],
                    e4   : [fr: "Implacable",],
            ],
            [
                    image: "http://static.mnium.org/images/contenu/actus/mmorpg/the_elder_scrolls_online/artisanat/alchimie/teso_ancolie.jpg",
                    name :
                            [
                                    en: "Columbine",
                                    fr: "Ancolie",
                            ],
                    e1   : [fr: "Rend de la Santé",],
                    e2   : [fr: "Rend de la Vigueur",],
                    e3   : [fr: "Rend de la Magie",],
                    e4   : [fr: "Implacable",],
            ],
            [
                    image: "http://static.mnium.org/images/contenu/actus/mmorpg/the_elder_scrolls_online/artisanat/alchimie/teso_bleuet.jpg",
                    name :
                            [
                                    en: "Corn Flower",
                                    fr: "Bleuet",
                            ],
                    e1   : [fr: "Rend de la Magie",],
                    e2   : [fr: "Réduit la Santé",],
                    e3   : [fr: "Augmente la puissance des sorts",],
                    e4   : [fr: "Détection",],
            ],
            [
                    image: "http://static.mnium.org/images/contenu/actus/mmorpg/the_elder_scrolls_online/artisanat/alchimie/teso_cardamine.jpg",
                    name :
                            [
                                    en: "Lady's Smock",
                                    fr: "Cardamine des Prés",
                            ],
                    e1   : [fr: "Augmente la puissance des sorts",],
                    e2   : [fr: "Rend de la Magie",],
                    e3   : [fr: "Diminue la résistance aux sorts",],
                    e4   : [fr: "Sort critique",],
            ],
            [
                    image: "http://static.mnium.org/images/contenu/actus/mmorpg/the_elder_scrolls_online/artisanat/alchimie/teso_chapeau_blanc.jpg",
                    name :
                            [
                                    en: "White Cap",
                                    fr: "Chapeau blanc",
                            ],
                    e1   : [fr: "Diminue la puissance des sorts",],
                    e2   : [fr: "Augmente la résistance aux sorts",],
                    e3   : [fr: "Réduit la Magie",],
                    e4   : [fr: "Diminue les sorts critique",],
            ],
            [
                    image: "http://static.mnium.org/images/contenu/actus/mmorpg/the_elder_scrolls_online/artisanat/alchimie/teso_chardon_beni.jpg",
                    name :
                            [
                                    en: "Blessed Thistle",
                                    fr: "Chardon béni",
                            ],
                    e1   : [fr: "Rend de la Vigueur",],
                    e2   : [fr: "Réduit la Santé",],
                    e3   : [fr: "Augmente la puissance de l'arme",],
                    e4   : [fr: "Vitesse",],
            ],
            [
                    image: "http://static.mnium.org/images/contenu/actus/mmorpg/the_elder_scrolls_online/artisanat/alchimie/tesp_coprin_violet.jpg",
                    name :
                            [
                                    en: "Violet Coprinus",
                                    fr: "Coprin violet",
                            ],
                    e1   : [fr: "Diminue la résistance aux sorts",],
                    e2   : [fr: "Augmente la puissance des sorts",],
                    e3   : [fr: "Réduit la Santé",],
                    e4   : [fr: "Réduit la Magie",],
            ],
            [
                    image: "http://static.mnium.org/images/contenu/actus/mmorpg/the_elder_scrolls_online/artisanat/alchimie/teso_entoloma.jpg",
                    name :
                            [
                                    en: "Blue Entoloma",
                                    fr: "Entoloma ",
                            ],
                    e1   : [fr: "Réduit la Magie",],
                    e2   : [fr: "Rend de la Santé",],
                    e3   : [fr: "Diminue la puissance des sorts",],
                    e4   : [fr: "Invisible",],
            ],
            [
                    image: "http://static.mnium.org/images/contenu/actus/mmorpg/the_elder_scrolls_online/artisanat/alchimie/teso_epine_dragon.jpg",
                    name :
                            [
                                    en: "Dragonthorn",
                                    fr: "Epine-de-Dragon",
                            ],
                    e1   : [fr: "Augmente la puissance de l'arme",],
                    e2   : [fr: "Diminue l'armure",],
                    e3   : [fr: "Rend de la Vigueur",],
                    e4   : [fr: "Arme critique",],
            ],
            [
                    image: "http://static.mnium.org/images/contenu/actus/mmorpg/the_elder_scrolls_online/artisanat/alchimie/teso_jacinthe_eau.jpg",
                    name :
                            [
                                    en: "Water Hyacinth",
                                    fr: "Jacinthe d'eau",
                            ],
                    e1   : [fr: "Rend de la Santé",],
                    e2   : [fr: "Arme critique",],
                    e3   : [fr: "Sort Critique",],
                    e4   : [fr: "Assomer",],
            ],
            [
                    image: "http://static.mnium.org/images/contenu/actus/mmorpg/the_elder_scrolls_online/artisanat/alchimie/tesp_lys_cime.jpg",
                    name :
                            [
                                    en: "Mountain Flower",
                                    fr: "Lys des Cimes",
                            ],
                    e1   : [fr: "Augmente l'armure",],
                    e2   : [fr: "Rend de la Vigueur",],
                    e3   : [fr: "Rend de la Santé",],
                    e4   : [fr: "Diminue la puissance de l'arme",],
            ],
            [
                    image: "http://static.mnium.org/images/contenu/actus/mmorpg/the_elder_scrolls_online/artisanat/alchimie/teso_mutinus_elegans.jpg",
                    name :
                            [
                                    en: "Stinkhorn",
                                    fr: "Mutinus Elégans",
                            ],
                    e1   : [fr: "Diminue l'armure",],
                    e2   : [fr: "Réduit la Santé",],
                    e3   : [fr: "Augmente la puissance de l'arme",],
                    e4   : [fr: "Réduit la vigueur",],
            ],
            [
                    image: "http://static.mnium.org/images/contenu/actus/mmorpg/the_elder_scrolls_online/artisanat/alchimie/teso_nirnrave.jpg",
                    name :
                            [
                                    en: "Nirnroot",
                                    fr: "Nirnrave",
                            ],
                    e1   : [fr: "Réduit la Santé",],
                    e2   : [fr: "Diminue l'Arme critique",],
                    e3   : [fr: "Diminue les sorts critique",],
                    e4   : [fr: "Invisible",],
            ],
            [
                    image: "http://static.mnium.org/images/contenu/actus/mmorpg/the_elder_scrolls_online/artisanat/alchimie/teso_noctuelle.jpg",
                    name :
                            [
                                    en: "Bugloss",
                                    fr: "Noctuelle",
                            ],
                    e1   : [fr: "Augmente la résistance aux sorts",],
                    e2   : [fr: "Rend de la Santé",],
                    e3   : [fr: "Diminue la puissance des sorts",],
                    e4   : [fr: "Rend de la Magie",],
            ],
            [
                    image: "http://static.mnium.org/images/contenu/actus/mmorpg/the_elder_scrolls_online/artisanat/alchimie/teso_pied_lutin.jpg",
                    name :
                            [
                                    en: "Imp Stool",
                                    fr: "Pied de lutin",
                            ],
                    e1   : [fr: "Diminue la puissance de l'arme",],
                    e2   : [fr: "Augmente l'armure",],
                    e3   : [fr: "Réduit la Vigueur",],
                    e4   : [fr: "Diminue l'Arme critique",],
            ],
            [
                    image: "http://static.mnium.org/images/contenu/actus/mmorpg/the_elder_scrolls_online/artisanat/alchimie/teso_ressule_emetique.jpg",
                    name :
                            [
                                    en: "Emetic Russula",
                                    fr: "Russule émétique",
                            ],
                    e1   : [fr: "Réduit la Santé",],
                    e2   : [fr: "Réduit la Vigueur",],
                    e3   : [fr: "Réduit la Magie",],
                    e4   : [fr: "Assomer",],
            ],
            [
                    image: "http://static.mnium.org/images/contenu/actus/mmorpg/the_elder_scrolls_online/artisanat/alchimie/teso_russule_phospho.jpg",
                    name :
                            [
                                    en: "Luminous Russula",
                                    fr: "Russule phosphorescente",
                            ],
                    e1   : [fr: "Réduit la Vigueur",],
                    e2   : [fr: "Rend de la Santé",],
                    e3   : [fr: "Diminue la puissance de l'arme",],
                    e4   : [fr: "Réduit la vitesse",],
            ],
            [
                    image: "http://static.mnium.org/images/contenu/actus/mmorpg/the_elder_scrolls_online/artisanat/alchimie/teso_truffe_namira.jpg",
                    name :
                            [
                                    en: "Namira's Rot",
                                    fr: "Truffe de Namira",
                            ],
                    e1   : [fr: "Sort critique",],
                    e2   : [fr: "Invisible",],
                    e3   : [fr: "Implacable",],
                    e4   : [fr: "Vitesse",],
            ]
    ]
    private static
    def EFFECTS = [
            "Blessed Thistle" : [e1: [en: "Restore Stamina", fr: "Rend de la Vigueur",], e2: [en: "Ravage Health", fr: "Réduit la Santé",], e3: [en: "Increase Weapon Power", fr: "Augmente la puissance de l'arme",], e4: [en: "Speed", fr: "Vitesse",]],
            "Blue Entoloma"   : [e1: [en: "Ravage Magicka", fr: "Réduit la Magie",], e2: [en: "Restore Health", fr: "Rend de la Santé",], e3: [en: "Lower Spell Power", fr: "Diminue la puissance des sorts",], e4: [en: "Invisibility", fr: "Invisible",]],
            "Bugloss"         : [e1: [en: "Increase Spell Resist", fr: "Augmente la résistance aux sorts",], e2: [en: "Restore Health", fr: "Rend de la Santé",], e3: [en: "Lower Spell Power", fr: "Diminue la puissance des sorts",], e4: [en: "Restore Magicka", fr: "Rend de la Magie",]],
            "Columbine"       : [e1: [en: "Restore Health", fr: "Rend de la Santé",], e2: [en: "Restore Stamina", fr: "Rend de la Vigueur",], e3: [en: "Restore Magicka", fr: "Rend de la Magie",], e4: [en: "Implacable", fr: "Implacable",]],
            "Corn Flower"     : [e1: [en: "Restore Magicka", fr: "Rend de la Magie",], e2: [en: "Ravage Health", fr: "Réduit la Santé",], e3: [en: "Increase Spell Power", fr: "Augmente la puissance des sorts",], e4: [en: "Detection", fr: "Détection",]],
            "Dragonthorn"     : [e1: [en: "Increase Weapon Power", fr: "Augmente la puissance de l'arme",], e2: [en: "Lower Armor", fr: "Diminue l'armure",], e3: [en: "Restore Stamina", fr: "Rend de la Vigueur",], e4: [en: "Weapon Crit", fr: "Arme critique",]],
            "Emetic Russula"  : [e1: [en: "Ravage Health", fr: "Réduit la Santé",], e2: [en: "Ravage Stamina", fr: "Réduit la Vigueur",], e3: [en: "Ravage Magicka", fr: "Réduit la Magie",], e4: [en: "Stun", fr: "Assomer",]],
            "Imp Stool"       : [e1: [en: "Lower Weapon Power", fr: "Diminue la puissance de l'arme",], e2: [en: "Increase Armor", fr: "Augmente l'armure",], e3: [en: "Ravage Stamina", fr: "Réduit la Vigueur",], e4: [en: "Lower Weapon Crit", fr: "Diminue l'Arme critique",]],
            "Lady's Smock"    : [e1: [en: "Increase Spell Power", fr: "Augmente la puissance des sorts",], e2: [en: "Restore Magicka", fr: "Rend de la Magie",], e3: [en: "Lower Spell Resist", fr: "Diminue la résistance aux sorts",], e4: [en: "Spell Crit", fr: "Sort critique",]],
            "Luminous Russula": [e1: [en: "Ravage Stamina", fr: "Réduit la Vigueur",], e2: [en: "Restore Health", fr: "Rend de la Santé",], e3: [en: "Lower Weapon Power", fr: "Diminue la puissance de l'arme",], e4: [en: "Reduce Speed", fr: "Réduit la vitesse",]],
            "Mountain Flower" : [e1: [en: "Increase Armor", fr: "Augmente l'armure",], e2: [en: "Restore Stamina", fr: "Rend de la Vigueur",], e3: [en: "Restore Health", fr: "Rend de la Santé",], e4: [en: "Lower Weapon Power", fr: "Diminue la puissance de l'arme",]],
            "Namira's Rot"    : [e1: [en: "Spell Crit", fr: "Sort critique",], e2: [en: "Invisibility", fr: "Invisible",], e3: [en: "Implacable", fr: "Implacable",], e4: [en: "Speed", fr: "Vitesse",]],
            "Nirnroot"        : [e1: [en: "Ravage Health", fr: "Réduit la Santé",], e2: [en: "Lower Weapon Crit", fr: "Diminue l'Arme critique",], e3: [en: "Lower Spell Crit", fr: "Diminue les sorts critique",], e4: [en: "Invisibility", fr: "Invisible",]],
            "Stinkhorn"       : [e1: [en: "Lower Armor", fr: "Diminue l'armure",], e2: [en: "Ravage Health", fr: "Réduit la Santé",], e3: [en: "Increase Weapon Power", fr: "Augmente la puissance de l'arme",], e4: [en: "Ravage Stamina", fr: "Réduit la vigueur",]],
            "Violet Coprinus" : [e1: [en: "Lower Spell Resist", fr: "Diminue la résistance aux sorts",], e2: [en: "Increase Spell Power", fr: "Augmente la puissance des sorts",], e3: [en: "Ravage Health", fr: "Réduit la Santé",], e4: [en: "Ravage Magicka", fr: "Réduit la Magie",]],
            "Water Hyacinth"  : [e1: [en: "Restore Health", fr: "Rend de la Santé",], e2: [en: "Weapon Crit", fr: "Arme critique",], e3: [en: "Spell Crit", fr: "Sort Critique",], e4: [en: "Stun", fr: "Assomer",]],
            "White Cap"       : [e1: [en: "Lower Spell Power", fr: "Diminue la puissance des sorts",], e2: [en: "Increase Spell Resist", fr: "Augmente la résistance aux sorts",], e3: [en: "Ravage Magicka", fr: "Réduit la Magie",], e4: [en: "Lower Spell Crit", fr: "Diminue les sorts critique",]],
            "Wormwood"        : [e1: [en: "Weapon Crit", fr: "Arme critique",], e2: [en: "Detection", fr: "Détection",], e3: [en: "Reduce Speed", fr: "Réduit la vitesse",], e4: [en: "Implacable", fr: "Implacable",]],
    ]


    public static void main(String[] args) {
        def ingredientsFile = new File("D:\\Dev\\tmp\\teso-alchemy-ingredients.json")
        def effectsFile = new File("D:\\Dev\\tmp\\teso-alchemy-effects.json")
        def sqlFile = new File("D:\\Dev\\tmp\\teso-import.sql")
        if (ingredientsFile.exists()) {
            ingredientsFile.delete()
        }
        ingredientsFile.createNewFile()
        if (effectsFile.exists()) {
            effectsFile.delete()
        }
        effectsFile.createNewFile()
        if (sqlFile.exists()) {
            sqlFile.delete()
        }
        sqlFile.createNewFile()

        def ingredientList = []
        def effectsSql = []
        def ingredientsSql = []
        def translationsSql = []
        def linkEffectIngredientSql = []
        def effectsMap = new HashMap()
        ITEMS.each { current ->
            def img = current.image.toURL().openStream().bytes.encodeBase64().toString()
            def fr = current.name.fr
            def en = current.name.en
            def ingredientId = constructId(en)
            //INSERT INTO funds (ID, date, price) VALUES (23, DATE('2013-02-12'), 22.5) ON DUPLICATE KEY UPDATE ID = 23;
            ingredientsSql << "INSERT INTO INGREDIENT (REF, IMAGE) VALUES ('$ingredientId', '$img');"
            translationsSql << "INSERT INTO TRANSLATION (LOCALE, REF, VALUE) VALUES ('en', 'INGREDIENT_$ingredientId', '${en.replace("'", "''")}');"
            translationsSql << "INSERT INTO TRANSLATION (LOCALE, REF, VALUE) VALUES ('fr', 'INGREDIENT_$ingredientId', '${fr.replace("'", "''")}');"
            def effects = EFFECTS[en]
            if (effects) {
                //ingr_effect_link (ingre_ref varchar(255) not null, effect_ref varchar(255) not null);
                def e1Id = constructId(effects.e1.en)
                def e2Id = constructId(effects.e2.en)
                def e3Id = constructId(effects.e3.en)
                def e4Id = constructId(effects.e4.en)
                linkEffectIngredientSql << "INSERT INTO INGR_EFFECT_LINK (INGRE_REF, EFFECT_REF) VALUES ('$ingredientId', '$e1Id');"
                linkEffectIngredientSql << "INSERT INTO INGR_EFFECT_LINK (INGRE_REF, EFFECT_REF) VALUES ('$ingredientId', '$e2Id');"
                linkEffectIngredientSql << "INSERT INTO INGR_EFFECT_LINK (INGRE_REF, EFFECT_REF) VALUES ('$ingredientId', '$e3Id');"
                linkEffectIngredientSql << "INSERT INTO INGR_EFFECT_LINK (INGRE_REF, EFFECT_REF) VALUES ('$ingredientId', '$e4Id');"
                processEffect(effectsMap, effectsSql, translationsSql, effects.e1)
                processEffect(effectsMap, effectsSql, translationsSql, effects.e2)
                processEffect(effectsMap, effectsSql, translationsSql, effects.e3)
                processEffect(effectsMap, effectsSql, translationsSql, effects.e4)

                ingredientList << "{" +
                        "\"ref\":\"${ingredientId}\"," +
                        "\"name\":{" +
                        "\"en\":\"$en\"," +
                        "\"fr\":\"$fr\"" +
                        "}," +
                        "\"img\":\"$img\"," +
                        "\"effects\":[" +
                        "\"${e1Id}\"," +
                        "\"${e2Id}\"," +
                        "\"${e3Id}\"," +
                        "\"${e4Id}\"" +
                        "]" +
                        "}"
            }
        }
        ingredientsFile << "[\n"
        ingredientsFile << ingredientList.sort().join(",\n")
        ingredientsFile << "\n]"
        def effectList = []
        effectsMap.each { key, value ->
            effectList << "{" +
                    "\"ref\":\"$key\"," +
                    "\"name\":{" +
                    "\"en\":\"${value.en}\"," +
                    "\"fr\":\"${value.fr}\"" +
                    "}" +
                    "}"
        }
        effectsFile << "[\n"
        effectsFile << effectList.sort().join(",\n")
        effectsFile << "\n]"
        sqlFile << "# Ingredients\n"
        sqlFile << ingredientsSql.sort().join("\n")
        sqlFile << "\n# Effects\n"
        sqlFile << effectsSql.sort().join("\n")
        sqlFile << "\n# Link between ingredients and effects\n"
        sqlFile << linkEffectIngredientSql.sort().join("\n")
        sqlFile << "\n# Translations\n"
        sqlFile << translationsSql.sort().join("\n")
    }

    private static void processEffect(Map<String, Object> effects, List effectsSql, List translationsSql, def effect) {
        def id = constructId(effect.en)
        if (!effects.containsKey(id)) {
            effectsSql << "INSERT INTO EFFECT (REF) VALUES (\"$id\");"
            translationsSql << "INSERT INTO TRANSLATION (LOCALE, REF, VALUE) VALUES ('en', 'EFFECT_$id', '${effect.en.replace("'", "''")}');"
            translationsSql << "INSERT INTO TRANSLATION (LOCALE, REF, VALUE) VALUES ('fr', 'EFFECT_$id', '${effect.fr.replace("'", "''")}');"
            effects.put(id, effect)
        }
    }

    private static String constructId(String base) {
        return base.replaceAll("(\\.|-|[ ]|')", "_").toUpperCase()
    }

}
