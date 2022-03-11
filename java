var image=null;
var image2=null;
var image3=null;
var canvas = document.getElementById("can1");
var canvas2= document.getElementById("can2");
var canvas3= document.getElementById("can3");
var canvas4= document.getElementById("can4");
var canvas5= document.getElementById("can5");
var canvas6= document.getElementById("can6");
var ainput1 = document.getElementById("finput");
var bginpunt= document.getElementById("binput");
function upload() {
  image=new SimpleImage(ainput1);
  
  image.drawTo(canvas);
}
function Upload() {
  image2=new SimpleImage(bginpunt);
  
  image2.drawTo(canvas3);
}
function imageLoaded() {
  if (image === null || !image.complete()) {
    return false;
  }
  else {
    return true;
  }
}
function reSet(){ 
  var ctx= canvas.getContext("2d");
  ctx.clearRect(0,0,canvas.width,canvas.height);
  image=null;
}
function changeRed(){
  for (var pix of image.values()){
  pix.setRed(255);
  }
 image.drawTo(canvas3);
}
function makegray() {
  if (imageLoaded()) {
  image = new SimpleImage(image);
    
  for (var pixel of image.values()) {
    var avg = (pixel.getRed() + pixel.getGreen() + pixel.getBlue())/3;
    pixel.setRed(avg);
    pixel.setGreen(avg);
    pixel.setBlue(avg);
  }
  image.drawTo(canvas3);
  
  }
  else { 
  alert("Image isn't loaded!");
  }
}
function changetorainbow(){
  if(imageLoaded()){
    image=new SimpleImage(canvas);
    
    var height1=image.getHeight()/7;
    for(var pix of image.values()){
      var avg = (pix.getRed() + pix.getGreen() + pix.getBlue())/3;
      if(avg<128&&pix.getY()<height1){
    
        pix.setRed(avg*2);
        pix.setBlue(0);
        pix.setGreen(0);
      }
    else if 
      (avg>=128&&pix.getY()<height1){
      pix.setRed(255);
      pix.setBlue(2*avg-255);
      pix.setGreen(2&avg-255);
    }
      
    else if 
      (avg<128&&pix.getY()<height1*2&&pix.getY()>height1){
        pix.setRed(avg*2);
        pix.setBlue(avg*0.8);
        pix.setGreen(0);
    }
    else if 
      (avg>=128&&pix.getY()<height1*2&&pix.getY()>height1){
        pix.setRed(255);
        pix.setBlue(1.2*avg-51);
        pix.setGreen(2*avg-255);
    }
    else if 
      (pix.getY()<height1*3&&pix.getY()>=height1*2){
        fileteryellow(pix);
      }
      else if 
        (pix.getY()<height1*4&&pix.getY()>=height1*3){
          filetergreen(pix);
        }
      else if
        (pix.getY()<height1*5&&pix.getY()>=height1*4){
          fileterblue(pix);
        }
      else if 
        (pix.getY()<height1*6&&pix.getY()>=height1*5){
          fileterindigo(pix);
        }
      else if 
        (pix.getY()<height1*7&&pix.getY()>=height1*6){
          fileterviolet(pix);
        }
    }
  }
      image.drawTo(canvas3);


}
function fileteryellow(pix){ 
  var avg = (pix.getRed() + pix.getGreen() + pix.getBlue())/3;
  
   if (avg < 128) {
      pix.setRed(avg*2);
      pix.setGreen(avg * 2);
      pix.setBlue(0);
    }
    else {
      pix.setRed(255);
      pix.setGreen(255);
      pix.setBlue(avg*2- 255);
    }
}
function filetergreen(pix){
  var avg = (pix.getRed() + pix.getGreen() + pix.getBlue())/3;
  if (avg<128){
    pix.setRed(0);
    pix.setGreen(2*avg);
    pix.setBlue(0);
  }
   else
     {
       pix.setRed(2*avg-255);
       pix.setGreen(255);
       pix.setBlue(2*avg-255);
     }
  }
  function fileterblue(pix){ 
    var avg = (pix.getRed() + pix.getGreen() + pix.getBlue())/3;
    if (avg<128){
    pix.setRed(0);
    pix.setGreen(0);
    pix.setBlue(2*avg);}
  
   else
     {
       pix.setRed(2*avg-255);
       pix.setGreen(2*avg-255);
       pix.setBlue(255);
    
  }                       
}
function fileterindigo(pix){
  var avg = (pix.getRed() + pix.getGreen() + pix.getBlue())/3; 
  if (avg<128){
    pix.setRed(0.8*avg);
    pix.setGreen(0);
    pix.setBlue(2*avg);
  }
   else
     {
       pix.setRed(1.2*avg-51);
       pix.setGreen(2*avg-255);
       pix.setBlue(255);
}
}
function fileterviolet(pix){
  var avg = (pix.getRed() + pix.getGreen() + pix.getBlue())/3; 
  if (avg<128){
    pix.setRed(1.6*avg);
    pix.setGreen(0);
    pix.setBlue(1.6*avg);
  }
   else
     {
       pix.setRed(0.4*avg+153);
       pix.setGreen(2*avg-255);
       pix.setBlue(0.4*avg+153);
}
}
function changeBlur(){
 if(imageLoaded()){
   image=new SimpleImage(canvas);
 for (var pix of image.values()){
   var x =pix.getX();
   var y=pix.getY();
   var height=image.getHeight();
   var width=image.getWidth();
   var rand=Math.random();
   
   if(rand<0.5){
    var x1=x+randnmnum(-22,8);
     var y1=y+randnmnum(-6,15);
     if(x1<0){
       x1=0;
     }
     if (x1 > width - 1){
          x1 = width - 1;
        }
        if (y1 < 0){
          y1 = 0;
        }
        if (y1 > height - 1){
          y1 = height - 1;
        }
   var pix=image.getPixel(x1,y1);
     image.setPixel(x,y,pix);
   }
 }
 image.drawTo(canvas3);
 }
 }
  function randnmnum(min, max) {
  return Math.floor(Math.random()*(max-1) + min);
}

function cropimage(){
  
   var start = new SimpleImage(image);
  var hide = new SimpleImage(image2);
  
  var cropWidth = start.getWidth();
  if(cropWidth > hide.getWidth()){
    cropWidth = hide.getWidth();
  }
  var cropHeight = start.getHeight();
  if(cropHeight > hide.getHeight()){
    cropHeight = hide.getHeight();
  }
  
  hide = crop(hide,cropWidth,cropHeight);
  return hide.drawTo(canvas2); 
}



function crop(image,width,height){
  var new1 = new SimpleImage(width,height);
  for(var px of image.values()){
    var x = px.getX();
    var y = px.getY();
    
    if(x < width && y < height){
      var np = new1.getPixel(x,y);
      np.setRed(px.getRed());
      np.setGreen(px.getGreen());
      np.setBlue(px.getBlue());
      new1.setPixel(x,y,np);
    }
  }
  return new1;
}
function clearbits(pixval){
  var x=Math.floor(pixval/16)*16;
  return x;
}


function chopimage(){
  var image3=new SimpleImage(image.getWidth(),image.getHeight());
 
  for (var px of image.values()){
  var x=px.getX();
    var y=px.getY();
   px.setRed(clearbits(px.getRed()));
   px.setBlue(clearbits(px.getBlue()));
   px.setGreen(clearbits(px.getGreen()));
 }

return image.drawTo(canvas4);
}
function shifImage(){
  var shifImage=new SimpleImage(image2.getWidth(),image2.getHeight());  
  for(var px of image2.values()){
        px.setRed(px.getRed()/16);
        px.setBlue(px.getBlue()/16);
        px.setGreen(px.getGreen()/16);
    }
    return image2.drawTo(canvas5);
}
function combineimage(){
    var answer=new SimpleImage(image.getWidth(),image.getHeight());
    for( var px of answer.values()){
        var x =px.getX();
        var y=px.getY();
        var aPixel=image.getPixel(x,y);
        var bpixel=image2.getPixel(x,y);
        px.setRed(aPixel.getRed()+bpixel.getRed());
        px.setBlue(aPixel.getBlue()+bpixel.getBlue());
        px.setGreen(aPixel.getGreen()+bpixel.getGreen());
        
    }
    return answer.drawTo(canvas6);
}
