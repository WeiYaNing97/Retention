import request from '@/utils/request'

// 查询商品测试列表
export function listTestProduct(query) {
  return request({
    url: '/test/testProduct/list',
    method: 'get',
    params: query
  })
}

// 查询商品测试详细
export function getTestProduct(id) {
  return request({
    url: '/test/testProduct/' + id,
    method: 'get'
  })
}

// 新增商品测试
export function addTestProduct(data) {
  return request({
    url: '/test/testProduct',
    method: 'post',
    data: data
  })
}

// 修改商品测试
export function updateTestProduct(data) {
  return request({
    url: '/test/testProduct',
    method: 'put',
    data: data
  })
}

// 删除商品测试
export function delTestProduct(id) {
  return request({
    url: '/test/testProduct/' + id,
    method: 'delete'
  })
}
