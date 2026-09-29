import type {
  OpenAPIClient,
  Parameters,
  UnknownParamsObject,
  OperationResponse,
  AxiosRequestConfig,
} from 'openapi-client-axios';

declare namespace Components {
    namespace Schemas {
        /**
         * Representa um aluno
         */
        export interface Aluno {
            id?: number; // int32
            nome?: string;
            curso: string;
            /**
             * Turma do aluno
             * example:
             * T001
             */
            turma?: string;
        }
    }
}
declare namespace Paths {
    namespace Atualizar {
        namespace Parameters {
            export type Id = number; // int32
        }
        export interface PathParameters {
            id: Parameters.Id /* int32 */;
        }
        export type RequestBody = /* Representa um aluno */ Components.Schemas.Aluno;
        namespace Responses {
            export interface $404 {
            }
        }
    }
    namespace Cadastro {
        export type RequestBody = /* Representa um aluno */ Components.Schemas.Aluno;
        namespace Responses {
            export interface $404 {
            }
        }
    }
    namespace GetAluno {
        namespace Parameters {
            export type Id = number; // int32
        }
        export interface PathParameters {
            id: Parameters.Id /* int32 */;
        }
        namespace Responses {
            export type $200 = /* Representa um aluno */ Components.Schemas.Aluno;
            export interface $400 {
            }
        }
    }
    namespace GetAluno1 {
        namespace Responses {
            export interface $404 {
            }
        }
    }
    namespace GetAlunoTurma {
        namespace Parameters {
            export type Turma = string;
        }
        export interface PathParameters {
            turma: Parameters.Turma;
        }
        namespace Responses {
            export interface $404 {
            }
        }
    }
    namespace Remover {
        namespace Parameters {
            export type Id = number; // int32
        }
        export interface PathParameters {
            id: Parameters.Id /* int32 */;
        }
        namespace Responses {
            export interface $200 {
            }
            export interface $404 {
            }
        }
    }
}


export interface OperationMethods {
  /**
   * getAluno
   */
  'getAluno'(
    parameters?: Parameters<Paths.GetAluno.PathParameters> | null,
    data?: any,
    config?: AxiosRequestConfig  
  ): OperationResponse<Paths.GetAluno.Responses.$200>
  /**
   * atualizar
   */
  'atualizar'(
    parameters?: Parameters<Paths.Atualizar.PathParameters> | null,
    data?: Paths.Atualizar.RequestBody,
    config?: AxiosRequestConfig  
  ): OperationResponse<any>
  /**
   * remover
   */
  'remover'(
    parameters?: Parameters<Paths.Remover.PathParameters> | null,
    data?: any,
    config?: AxiosRequestConfig  
  ): OperationResponse<Paths.Remover.Responses.$200>
  /**
   * getAluno_1 - Lista alunos
   * 
   * Obtem a lista de todos os alunos
   */
  'getAluno_1'(
    parameters?: Parameters<UnknownParamsObject> | null,
    data?: any,
    config?: AxiosRequestConfig  
  ): OperationResponse<any>
  /**
   * cadastro
   */
  'cadastro'(
    parameters?: Parameters<UnknownParamsObject> | null,
    data?: Paths.Cadastro.RequestBody,
    config?: AxiosRequestConfig  
  ): OperationResponse<any>
  /**
   * getAlunoTurma
   */
  'getAlunoTurma'(
    parameters?: Parameters<Paths.GetAlunoTurma.PathParameters> | null,
    data?: any,
    config?: AxiosRequestConfig  
  ): OperationResponse<any>
}

export interface PathsDictionary {
  ['/aluno/{id}']: {
    /**
     * getAluno
     */
    'get'(
      parameters?: Parameters<Paths.GetAluno.PathParameters> | null,
      data?: any,
      config?: AxiosRequestConfig  
    ): OperationResponse<Paths.GetAluno.Responses.$200>
    /**
     * atualizar
     */
    'put'(
      parameters?: Parameters<Paths.Atualizar.PathParameters> | null,
      data?: Paths.Atualizar.RequestBody,
      config?: AxiosRequestConfig  
    ): OperationResponse<any>
    /**
     * remover
     */
    'delete'(
      parameters?: Parameters<Paths.Remover.PathParameters> | null,
      data?: any,
      config?: AxiosRequestConfig  
    ): OperationResponse<Paths.Remover.Responses.$200>
  }
  ['/aluno']: {
    /**
     * getAluno_1 - Lista alunos
     * 
     * Obtem a lista de todos os alunos
     */
    'get'(
      parameters?: Parameters<UnknownParamsObject> | null,
      data?: any,
      config?: AxiosRequestConfig  
    ): OperationResponse<any>
    /**
     * cadastro
     */
    'post'(
      parameters?: Parameters<UnknownParamsObject> | null,
      data?: Paths.Cadastro.RequestBody,
      config?: AxiosRequestConfig  
    ): OperationResponse<any>
  }
  ['/aluno/turma/{turma}']: {
    /**
     * getAlunoTurma
     */
    'get'(
      parameters?: Parameters<Paths.GetAlunoTurma.PathParameters> | null,
      data?: any,
      config?: AxiosRequestConfig  
    ): OperationResponse<any>
  }
}

export type Client = OpenAPIClient<OperationMethods, PathsDictionary>


export type Aluno = Components.Schemas.Aluno;
