uniform sampler2D cloud;
uniform sampler2D detail;
uniform vec3  sunDirection;
uniform float time;
uniform vec4  fogColor;
uniform vec4  cloudColor;
uniform float density;
uniform float cloudInvScale;
uniform float detailInvScale;
uniform vec2 cloudSpeed;
uniform vec2 detailSpeed;

varying vec2  oUv;
varying float oGlow;

void main(void)
{
  
   vec2 cloudOffset = cloudSpeed * time;
   vec2 detailOffset = detailSpeed * time;

   float a1 = texture2D (cloud, (oUv + cloudOffset) * cloudInvScale).b;
   float a2 = texture2D (detail,(oUv + detailOffset) * detailInvScale).b;
  
   vec3 p_sunDirection = normalize (sunDirection) * -0.01;
        p_sunDirection.x = p_sunDirection.x;
        p_sunDirection.y = -p_sunDirection.z;
        p_sunDirection.z = 0.0;

   vec4 p_fogColor = fogColor;
    
   vec4 oCol = cloudColor * (p_fogColor *2.0);
   oCol.a *= clamp (a1 + a2 - 1.0, 0.0, 1.0);
   oCol.rgb *= 1 - oCol.a * density;

   vec3  absorption = vec3(0.0);
         absorption += clamp (
                         texture2D (cloud,  (oUv + sunDirection.xy * 0.2 + cloudOffset) * cloudInvScale).rgb +
                         texture2D (detail, (oUv + sunDirection.xy * 0.2 + detailOffset) * detailInvScale).rgb - 1.0, 0.0, 1.0);
         absorption += clamp (
                         texture2D (cloud,  (oUv + sunDirection.xy * 0.4 + cloudOffset) * cloudInvScale).rgb +
                         texture2D (detail, (oUv + sunDirection.xy * 0.4 + detailOffset) * detailInvScale).rgb - 1.0, 0.0, 1.0);
         absorption += clamp (
                         texture2D (cloud,  (oUv + sunDirection.xy * 0.6 + cloudOffset) * cloudInvScale).rgb +
                         texture2D (detail, (oUv + sunDirection.xy * 0.6 + detailOffset) * detailInvScale).rgb - 1.0, 0.0, 1.0);
         absorption += clamp (
                         texture2D (cloud,  (oUv + sunDirection.xy * 0.8 + cloudOffset) * cloudInvScale).rgb +
                         texture2D (detail, (oUv + sunDirection.xy * 0.8 + detailOffset) * detailInvScale).rgb - 1.0, 0.0, 1.0);
         absorption += clamp (
                         texture2D (cloud,  (oUv + sunDirection.xy * 1.0 + cloudOffset) * cloudInvScale).rgb +
                         texture2D (detail, (oUv + sunDirection.xy * 1.0 + detailOffset) * detailInvScale).rgb - 1.0, 0.0, 1.0);
  
   oCol.rgb *= 1.0 - clamp (absorption * 0.2, 0.0, 1.0) * density;

   oCol.rgb *= oGlow;
  
   gl_FragColor = oCol;
}