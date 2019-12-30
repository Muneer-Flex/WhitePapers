The above two folders - ePO & payment-simulations should be placed under the below path:

	C:\Users\gssmunej\Muneer\Softwares\apisimulator-http-1.1-distro\apisimulator\apisimulator-http-1.1\examples

To Boot up the API's,

	cd into C:\Users\gssmunej\Muneer\Softwares\apisimulator-http-1.1-distro\apisimulator\apisimulator-http-1.1\bin
		
	apisimulator start /examples/payment-simulation [Boots up payment-simulation API's]

	apisimulator start /examples/ePO -p 8080 -admin_port 8090 [Boots up ePO API's]