import React from 'react';
import {View, Text, Image, TextInput, TouchableOpacity} from 'react-native';
import { Styles } from './styles';
import ImgProfile from '../../assets/images/profile.png';

export const Home = ()=>{
    return (
    <View style = {Styles.container}>  
        {/* View de Login de Usuario - icone e texto */}
       <View style = {Styles.PrimeiraView}>
           <Image source = {ImgProfile} style = {Styles.ImgProfile}/>
           <Text style = {Styles.TextoLogin}>LOGIN DE USUÁRIO</Text>
       </View>
        {/*View de texto de descrição */}
       <View>
 
        <Text style = {Styles.TextoDescrição}>
        "REALIZAR CADASTRO"
        </Text>

       </View>

        {/* View de 2 inputs + 1 botão + 1 texto  */}
       <View>
        <TextInput placeholder = 'Digite seu e-mail' style = {Styles.EstiloInputMail}/>
        <TextInput placeholder = 'Digite sua senha' style = {Styles.EstiloInputSenha}/>

        <TouchableOpacity style = {Styles.BotaoEntrar}>
            <Text style = {Styles.TextoBotao}>Entrar</Text>
        </TouchableOpacity>

        <TouchableOpacity style = {Styles.RECUPERAR}>
        <Text style = {Styles.TextoRECUPERAR}>RECUPERAR SENHA</Text>
        </TouchableOpacity>
        

       </View>

       {/* View de 2 botões: cadastro e entrar sem login */}
       <View style = {{flex: 1,
        flexDirection: 'row',
        alignItems: 'center',
        justifyContent: 'space-between',
        width: '100%'
        }}>

            <TouchableOpacity style = {Styles.CADASTRO}>
            <Text style = {Styles.TextoCADASTRO}>REALIZAR CADASTRO</Text>
            </TouchableOpacity>

            <TouchableOpacity style = {Styles.SEMLOGIN}>
                <Text style = {Styles.TextoSEMLOGIN}>ENTRAR SEM LOGIN</Text>
            </TouchableOpacity>

       </View>

    </View>    
    )
}