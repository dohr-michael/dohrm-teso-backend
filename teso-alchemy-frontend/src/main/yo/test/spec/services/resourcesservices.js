'use strict';

describe('Service: resourcesServices', function () {

  // load the service's module
  beforeEach(module('tesoAlchemyApp'));

  // instantiate service
  var resourcesServices;
  beforeEach(inject(function (_resourcesServices_) {
    resourcesServices = _resourcesServices_;
  }));

  it('should do something', function () {
    expect(!!resourcesServices).toBe(true);
  });

});
