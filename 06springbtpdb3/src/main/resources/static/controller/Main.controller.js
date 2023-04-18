sap.ui.define(["sap/ui/core/mvc/Controller",
               "sap/m/MessageBox",
               "hanuman/util/service",
               "sap/m/MessageToast"],
              function(Controller, MessageBox, Service, MessageToast){
				  return Controller.extend("hanuman.controller.Main",{
					  
					 onInit: function(){
						 var oModel = new sap.ui.model.json.JSONModel();
						 oModel.setData({
							 "vendors": 
									{
									    "companyName": "Hanuman Temple Wefare",
									    "contactPersion": "Sri Rama Dhutha",
									    "firstName": "Jambavantha",
									    "lastName": "Kishkinda",
									    "website": "hanumantemplewelfare.com",
									    "email": "jambavantha.kishkinda@htw.com",
									    "status": "Active",
									    "regDate": new Date()
									},
							"vendorsTab": []		
						 });
						 
						 this.getView().setModel(oModel);
						 
						 this.fetchAndLoadData();
						 
					 }, 

                fetchAndLoadData: function(){
					//Step 1 - Get the local Model access (/vendorsTab)
					var oModel = this.getView().getModel();
					//Step 2 - Call micro service GET
					Service.callService("/vendors","GET")
					.then(function(data){
						oModel.setProperty("/vendorsTab", data);
						MessageToast.show(data.length.toString() + " records loaded successfully");
						
					})
					.catch(function(oError){
						MessageBox.error("Data fetch failed");
					});										
				},

			onDelete: function(){
				//Step 1: Get the table object
				var oTable = this.getView().byId("table");
				MessageToast.show("Check the entries for deletion");
				//Step 2: Get all the selected records
				//Step 3: Call Service API to fire Delete - Loop
				//Handle response
			},		 
					 onSave: function(){
						 
						// MessageBox.confirm("Save alert")
					//Step 1: Get data from the Model - Whatever changed user did on the ui screen
					// will reflect inside model from UI
					var oModel = this.getView().getModel();
					var payload = oModel.getProperty("/vendors");
					
					var that = this;
					
					//Step 2: Use the service call object to post the data
					Service.callService("/vendors", "POST", payload)
					.then(function(){
						MessageBox.confirm("Your vendor is created successfully");
						
					//Once a new record is created table should be refreshed in UI to show the new record immediately
					//	that.fetchAndLoadData().bind(that);
					Service.callService("/vendors","GET")
					.then(function(data){
						oModel.setProperty("/vendorsTab", data);
						MessageToast.show(data.length.toString() + " records loaded successfully");
						
					})
					.catch(function(oError){
						MessageBox.error("Data fetch failed");
					});
					})
					.catch(function(){
						MessageBox.error("The vendor creation is failed")
					});
					 }
					  
				  });
			  } );