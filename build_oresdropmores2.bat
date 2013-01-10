@echo off
cd mcp
mkdir reobf\minecraft\bstramke\OresDropMores2Base
mkdir reobf\minecraft\bstramke\OresDropMores2Base\bstramke
mkdir reobf\minecraft\bstramke\OresDropMores2Base\buildcraft
mkdir reobf\minecraft\bstramke\OresDropMores2Base\buildcraft\api
mkdir reobf\minecraft\bstramke\OresDropMores2Base\buildcraft\api\inventory
move reobf\minecraft\bstramke\OresDropMores2 reobf\minecraft\bstramke\OresDropMores2Base\bstramke
move reobf\minecraft\bstramke\OresDropMores2NEIPlugin reobf\minecraft\bstramke\OresDropMores2Base\bstramke

mkdir reobf\minecraft\bstramke\OresDropMores2Base\bstramke\OresDropMores2\resources
mkdir reobf\minecraft\bstramke\OresDropMores2Base\bstramke\OresDropMores2\resources\textures
mkdir reobf\minecraft\bstramke\OresDropMores2Base\bstramke\OresDropMores2\resources\textures\gui


copy reobf\minecraft\buildcraft\api\inventory\* reobf\minecraft\bstramke\OresDropMores2Base\buildcraft\api\inventory
copy src\minecraft\bstramke\OresDropMores2\mcmod.info reobf\minecraft\bstramke\OresDropMores2Base\mcmod.info
copy src\minecraft\bstramke\OresDropMores2\resources\* reobf\minecraft\bstramke\OresDropMores2Base\bstramke\OresDropMores2\resources
copy src\minecraft\bstramke\OresDropMores2\resources\textures\* reobf\minecraft\bstramke\OresDropMores2Base\bstramke\OresDropMores2\resources\textures
copy src\minecraft\bstramke\OresDropMores2\resources\textures\gui\* reobf\minecraft\bstramke\OresDropMores2Base\bstramke\OresDropMores2\resources\textures\gui


cd reobf\minecraft\bstramke\OresDropMores2Base
"C:\Program Files\7-Zip\7z.exe" a -tzip mod_OresDropMores2.zip *
cd..
move OresDropMores2Base\mod_OresDropMores2.zip mod_OresDropMores2.zip
cd D:\GitHub\OresDropMores2
copy mcp\reobf\minecraft\bstramke\mod_OresDropMores2.zip mod_OresDropMores2.zip
pause