'use strict';

/**
 * @ngdoc function
 * @name tesoAlchemyApp.controller:EffectsCtrl
 * @description
 * # EffectsCtrl
 * Controller of the tesoAlchemyApp
 */
angular.module('tesoAlchemyApp')
  .factory('Utils', function () {
    return {
      /**
       * Sort by name function.
       * // TODO manage locales.
       * @param a
       * @param b
       * @returns {number}
       */
      sortNameAsc: function (a, b) {
        if (a.name['fr'] < b.name['fr']) return -1;
        if (a.name['fr'] > b.name['fr']) return 1;
        return 0;
      }
    }
  })
  .factory('IngredientsUtils', function (Utils) {
    return {
      /**
       * Sort a list of ingredients.
       * @param list list of ingredients.
       * @returns {*|Array.<T>}
       */
      sortNameAsc: function (list) {
        list.forEach(function (item) {
          item.effects = item.effects.sort(Utils.sortNameAsc);
        });
        return list.sort(Utils.sortNameAsc);
      }
    }
  })
  .factory('RecipeUtils', function (Utils) {
    return {
      /**
       * Sort items into recipe.
       * @param object
       */
      sortItems: function (object) {
        object.effects = object.effects.sort(Utils.sortNameAsc);
        object.ingredients = object.ingredients.sort(Utils.sortNameAsc);
        return object;
      }
    }
  });
