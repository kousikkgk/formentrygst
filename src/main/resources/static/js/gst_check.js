function check_gst(gst){
    if(gst.length != 15){
        //alert("Invalid Length of GSTIN");
        return false;
    }else{
        var state = parseInt(gst.substring(0, 2)); 
        // FIRST 2 CHARACTERS STATE CODE
        if(state < 1 || state > 37){
            //alert("Invalid First Two Characters of GSTIN");
            return false;
        }
        // NEXT 10 CHARACTERS PAN NO. VALIDATION
        var pan = gst.substring(2, 12).toUpperCase();
        var regex = /[a-zA-Z]{3}[PCHFATBLJG]{1}[a-zA-Z]{1}[0-9]{4}[a-zA-Z]{1}$/;
        if( !regex.test(pan) ){
            //alert("Invalid GSTIN");
            return false;
        }
        // DEFAULT 14TH CHARACTER 'Z'
        var char14 = gst[13].toUpperCase();
        if(char14 != "Z"){
            //lert("14th character of GSTIN should be 'Z'");
            return false;
        }
        // CHECKSUM DIGIT 
        if(check_gst_checksum(gst.substring(0, 14)) != gst[14]){
            //alert("Invalid GSTIN");
            return false;
        }

        return true;

    }
}
String.prototype.getw = function( value ) {
    for( var prop in this ) {
        if( this.hasOwnProperty( prop ) ) {
            if( this[ prop ] === value )
                return prop;
        }
    }
}
function check_gst_checksum(gst_wo){
    weight_c = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    gst = gst_wo.toUpperCase();
    var total_a1 = 0;
    for (var i = 0; i < gst.length; i++) {
        var weight = weight_c.getw(gst[i]);
        var factor = ( (i % 2) +1 );
        var product = weight * factor;
        var qu = Math.floor( product/36 );
        var re = product % 36;
        var a1 = qu + re;
        total_a1 += a1;
    }
    var d = total_a1 % 36;
    var dd = 36 - d;
    return weight_c[dd];
}
